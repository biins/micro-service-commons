package org.biins.commons.hystrix;

import java.util.Optional;
import java.util.function.Supplier;

import org.springframework.cache.Cache;
import org.springframework.cache.interceptor.SimpleKey;
import org.springframework.util.Assert;

import com.netflix.hystrix.HystrixCommand;

public class HystrixCacheLoader<T> {

	private final SimpleKey key;
	private final Class<T> cls;
	private Cache cache;

	public HystrixCacheLoader(SimpleKey key, Class<T> cls) {
		this.key = key;
		this.cls = cls;
	}

	public static <T> HystrixCacheLoader<T> of(SimpleKey key, Class<T> cls) {
		return new HystrixCacheLoader<>(key, cls);
	}

	public HystrixCacheLoader<T> with(Cache cache) {
		this.cache = cache;
		return this;
	}

	public Optional<T> getAndSet(Supplier<HystrixCommand<T>> supplier) {
		Assert.notNull(cache);
		Assert.notNull(supplier);

		T cacheResult = cache.get(key, cls);
		if (cacheResult != null) {
			return Optional.of(cacheResult);
		}

		HystrixCommand<T> response = supplier.get();
		T result = response.execute();
		if (response.isSuccessfulExecution() && result != null) {
			Cache.ValueWrapper value = cache.putIfAbsent(key, result);
			result = cls.cast(value.get());
		}

		return Optional.ofNullable(result);
	}
}
