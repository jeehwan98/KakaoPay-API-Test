package com.companimal.kakaoPay.model.dto;

import lombok.Data;
@Data
public class CardDTO {

    private String kakaopay_issuer_corp;            // kakaopay 발급사명
    private String kakaopay_issuer_corp_code;       // kakaopay 발급사 코드
    private String bin;                             // card bin
    private String card_type;                       // card type
    private String install_month;                   // 할부 개월 수 (없는 기능)
    private String approved_id;                     // 카드사 승인번호
    private String card_mid;                        // 카드사 가맹점 번호
    private String interest_free_install;           // 무이자할부 여부 (Y/N)
    private String installment_type;                // 할부 유형 (없는 기능)
    private String card_item_code;                  // 카드 상품 콬드

    public CardDTO() {
    }

    public CardDTO(String kakaopay_issuer_corp, String kakaopay_issuer_corp_code, String bin, String card_type, String install_month, String approved_id, String card_mid, String interest_free_install, String installment_type, String card_item_code) {
        this.kakaopay_issuer_corp = kakaopay_issuer_corp;
        this.kakaopay_issuer_corp_code = kakaopay_issuer_corp_code;
        this.bin = bin;
        this.card_type = card_type;
        this.install_month = install_month;
        this.approved_id = approved_id;
        this.card_mid = card_mid;
        this.interest_free_install = interest_free_install;
        this.installment_type = installment_type;
        this.card_item_code = card_item_code;
    }

    public String getKakaopay_issuer_corp() {
        return kakaopay_issuer_corp;
    }

    public void setKakaopay_issuer_corp(String kakaopay_issuer_corp) {
        this.kakaopay_issuer_corp = kakaopay_issuer_corp;
    }

    public String getKakaopay_issuer_corp_code() {
        return kakaopay_issuer_corp_code;
    }

    public void setKakaopay_issuer_corp_code(String kakaopay_issuer_corp_code) {
        this.kakaopay_issuer_corp_code = kakaopay_issuer_corp_code;
    }

    public String getBin() {
        return bin;
    }

    public void setBin(String bin) {
        this.bin = bin;
    }

    public String getCard_type() {
        return card_type;
    }

    public void setCard_type(String card_type) {
        this.card_type = card_type;
    }

    public String getInstall_month() {
        return install_month;
    }

    public void setInstall_month(String install_month) {
        this.install_month = install_month;
    }

    public String getApproved_id() {
        return approved_id;
    }

    public void setApproved_id(String approved_id) {
        this.approved_id = approved_id;
    }

    public String getCard_mid() {
        return card_mid;
    }

    public void setCard_mid(String card_mid) {
        this.card_mid = card_mid;
    }

    public String getInterest_free_install() {
        return interest_free_install;
    }

    public void setInterest_free_install(String interest_free_install) {
        this.interest_free_install = interest_free_install;
    }

    public String getInstallment_type() {
        return installment_type;
    }

    public void setInstallment_type(String installment_type) {
        this.installment_type = installment_type;
    }

    public String getCard_item_code() {
        return card_item_code;
    }

    public void setCard_item_code(String card_item_code) {
        this.card_item_code = card_item_code;
    }
}
