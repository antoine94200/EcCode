package com.codflix.backend.models;

public class History {
    private int id;
    private int userId;
    private int mediaId;
    private String startDate;
    private String endDate;
    private int watchDuration;

    public History(int id, int userId, int mediaId, String startDate, String endDate, int watchDuration) {
        this.id = id;
        this.userId = userId;
        this.mediaId = mediaId;
        this.startDate = startDate;
        this.endDate = endDate;
        this.watchDuration = watchDuration;
    }

    @Override
    public String toString() {
        return "StreamHistory{" +
                "id=" + id +
                ", userId=" + userId +
                ", streamId=" + mediaId +
                ", startDate='" + startDate + '\'' +
                ", endDate='" + endDate + '\'' +
                ", watchDuration=" + watchDuration +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getMediaId() {
        return mediaId;
    }

    public void setMediaId(int mediaId) {
        this.mediaId = mediaId;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public int getWatchDuration() {
        return watchDuration;
    }

    public void setWatchDuration(int watchDuration) {
        this.watchDuration = watchDuration;
    }
}
