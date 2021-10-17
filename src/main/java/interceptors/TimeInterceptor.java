package interceptors;

import annotations.Timer;

import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import java.sql.Time;

@Timer
@Interceptor
public class TimeInterceptor {
	@AroundInvoke
	public Object profile(InvocationContext invocationContext) throws Exception {
		long initTime = System.nanoTime();
		try {
			return invocationContext.proceed();
		}
		finally {
			long time = System.nanoTime() - initTime;
			System.out.println(invocationContext.getMethod() + "completed for " + time + " ns");
		}
	}
}
