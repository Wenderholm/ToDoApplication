package com.example.todoapplication.dto;

import java.time.Duration;
import java.time.LocalDateTime;

public class TaskDurationDto {

    private final LocalDateTime startTime;
    private final LocalDateTime completionTime;

    private final Duration duration;

    public TaskDurationDto(LocalDateTime startTime, LocalDateTime completionTime) {
        this.startTime = startTime;
        this.completionTime = completionTime;
        duration = Duration.between(startTime,completionTime);
    }

    public Duration getDuration() {
        return duration;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public LocalDateTime getCompletionTime() {
        return completionTime;
    }

    @Override
    public String toString() {
        String taskDurationFormatted = String.format("%02d:%02d:%02d",
                duration.toHoursPart(),
                duration.toMinutesPart(),
                duration.toSecondsPart()
        );

        return String.format(
                "Czas rozpoczęcia: %s\nCzas zakończenia: %s\nCzas wykonania zadania: %s",
                startTime.toString(),
                completionTime.toString(),
                taskDurationFormatted
        );
    }
}
