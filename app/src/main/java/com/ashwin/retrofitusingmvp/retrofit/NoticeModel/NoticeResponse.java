package com.ashwin.retrofitusingmvp.retrofit.NoticeModel;

import java.util.ArrayList;

public class NoticeResponse {
    private boolean success;
    private ArrayList<Notice> notice_list;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public ArrayList<Notice> getNotice_list() {
        return notice_list;
    }

    public void setNotice_list(ArrayList<Notice> notice_list) {
        this.notice_list = notice_list;
    }
}