package com.pengxo.retry;

import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;

import java.sql.SQLException;

@Service
public class RetryService {

    private int a = 10;

    @Retryable(maxAttempts = 4, backoff = @Backoff(delay = 3000))
    public void retryTest() throws SQLException {
        System.out.println("Hello retry.");
        a += 2;
        if (a < 30) throw new SQLException();
        a = 10;
    }

    @Recover
    private void recover(final Exception exception) {
        System.out.println("Hello recover.");
    }

}
