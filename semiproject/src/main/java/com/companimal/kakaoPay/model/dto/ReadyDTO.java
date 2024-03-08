package com.companimal.kakaoPay.model.dto;

import lombok.Data;

import java.util.Date;
@Data
public class ReadyDTO {

    private String tid;                     // 결제 고유 번호
    private String next_redirect_pc_url;    // 요청한 client가 pc웹일 경우 redirect kakaotalk으로 TMS를 보내기 위한 사용자입력화면이므로 redirect
    private Date created_at;                // 결제 준비 요청 시간

    public ReadyDTO() {
    }

    public ReadyDTO(String tid, String next_redirect_pc_url, Date created_at) {
        this.tid = tid;
        this.next_redirect_pc_url = next_redirect_pc_url;
        this.created_at = created_at;
    }

    public String getTid() {
        return tid;
    }

    public void setTid(String tid) {
        this.tid = tid;
    }

    public String getNext_redirect_pc_url() {
        return next_redirect_pc_url;
    }

    public void setNext_redirect_pc_url(String next_redirect_pc_url) {
        this.next_redirect_pc_url = next_redirect_pc_url;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    @Override
    public String toString() {
        return "ReadyDTO{" +
                "tid='" + tid + '\'' +
                ", next_redirect_pc_url='" + next_redirect_pc_url + '\'' +
                ", created_at=" + created_at +
                '}';
    }
}
