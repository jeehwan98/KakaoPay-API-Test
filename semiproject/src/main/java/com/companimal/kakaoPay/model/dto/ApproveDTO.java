package com.companimal.kakaoPay.model.dto;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class ApproveDTO {

    private String aid;                 // 요청고유 번호
    private String cid;                 // 가맹점 코드
    private String tid;                 // 결제 고유 번호**
    private String partner_order_id;    // 가맹점 주문번호
    private String partner_user_id;     // 가맹점 회원 id
    private String pg_token;            // 결제 승인 요청을 인증하는 코튼
    private AmountDTO amount;           // 결제 금액 정보
    private CardDTO car_info;          // 결제 상세 정보, 결제 수단이 카드일 경우만 포함
    private String payment_method_type; // 결제 수단 CARD 또는 MONEY
    private String item_name;           // 상품 이름
    private String item_code;           // 상품 코드
    private int quantity;               // 상품 수량
    private Timestamp created_at;       // 결제 준비 요청 시간
    private Timestamp approved_at;      // 결제 승인 시각
    private String payload;             // 결제 승인 요청에 대해 저장한 값, 요청 시 전달된 내용

    public ApproveDTO() {
    }

    public ApproveDTO(String aid, String cid, String tid, String partner_order_id, String partner_user_id, String pg_token, AmountDTO amount, CardDTO car_info, String payment_method_type, String item_name, String item_code, int quantity, Timestamp created_at, Timestamp approved_at, String payload) {
        this.aid = aid;
        this.cid = cid;
        this.tid = tid;
        this.partner_order_id = partner_order_id;
        this.partner_user_id = partner_user_id;
        this.pg_token = pg_token;
        this.amount = amount;
        this.car_info = car_info;
        this.payment_method_type = payment_method_type;
        this.item_name = item_name;
        this.item_code = item_code;
        this.quantity = quantity;
        this.created_at = created_at;
        this.approved_at = approved_at;
        this.payload = payload;
    }

    public String getAid() {
        return aid;
    }

    public void setAid(String aid) {
        this.aid = aid;
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public String getTid() {
        return tid;
    }

    public void setTid(String tid) {
        this.tid = tid;
    }

    public String getPartner_order_id() {
        return partner_order_id;
    }

    public void setPartner_order_id(String partner_order_id) {
        this.partner_order_id = partner_order_id;
    }

    public String getPartner_user_id() {
        return partner_user_id;
    }

    public void setPartner_user_id(String partner_user_id) {
        this.partner_user_id = partner_user_id;
    }

    public String getPg_token() {
        return pg_token;
    }

    public void setPg_token(String pg_token) {
        this.pg_token = pg_token;
    }

    public AmountDTO getAmount() {
        return amount;
    }

    public void setAmount(AmountDTO amount) {
        this.amount = amount;
    }

    public CardDTO getCar_info() {
        return car_info;
    }

    public void setCar_info(CardDTO car_info) {
        this.car_info = car_info;
    }

    public String getPayment_method_type() {
        return payment_method_type;
    }

    public void setPayment_method_type(String payment_method_type) {
        this.payment_method_type = payment_method_type;
    }

    public String getItem_name() {
        return item_name;
    }

    public void setItem_name(String item_name) {
        this.item_name = item_name;
    }

    public String getItem_code() {
        return item_code;
    }

    public void setItem_code(String item_code) {
        this.item_code = item_code;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Timestamp getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Timestamp created_at) {
        this.created_at = created_at;
    }

    public Timestamp getApproved_at() {
        return approved_at;
    }

    public void setApproved_at(Timestamp approved_at) {
        this.approved_at = approved_at;
    }

    public String getPayload() {
        return payload;
    }

    public void setPayload(String payload) {
        this.payload = payload;
    }

    @Override
    public String toString() {
        return "ApproveDTO{" +
                "aid='" + aid + '\'' +
                ", cid='" + cid + '\'' +
                ", tid='" + tid + '\'' +
                ", partner_order_id='" + partner_order_id + '\'' +
                ", partner_user_id='" + partner_user_id + '\'' +
                ", pg_token='" + pg_token + '\'' +
                ", amount=" + amount +
                ", car_info=" + car_info +
                ", payment_method_type='" + payment_method_type + '\'' +
                ", item_name='" + item_name + '\'' +
                ", item_code='" + item_code + '\'' +
                ", quantity=" + quantity +
                ", created_at=" + created_at +
                ", approved_at=" + approved_at +
                ", payload='" + payload + '\'' +
                '}';
    }
}
