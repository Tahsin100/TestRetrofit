package com.tahsin.testretrofit.models;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class Notice {

    @SerializedName("id")
    private String id;
    @SerializedName("title")
    private String title;
    @SerializedName("brief")
    private String brief;
    @SerializedName("filesource")
    private String filesource;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBrief() {
        return brief;
    }

    public void setBrief(String brief) {
        this.brief = brief;
    }

    public String getFilesource() {
        return filesource;
    }

    public void setFilesource(String filesource) {
        this.filesource = filesource;
    }

    public class NoticeList{

        @SerializedName("notice_list")
        private ArrayList<Notice> notice_List;

        public ArrayList<Notice> getNotice_List() {
            return notice_List;
        }

        public void setNotice_List(ArrayList<Notice> notice_List) {
            this.notice_List = notice_List;
        }
    }
}
