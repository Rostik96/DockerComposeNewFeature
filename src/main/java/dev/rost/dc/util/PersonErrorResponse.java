package dev.rost.dc.util;

import java.time.Instant;

public record PersonErrorResponse(String message, Instant timestamp) {}
