package com.companimal.kakaoPay.service;

import com.companimal.kakaoPay.model.dto.ApproveDTO;
import com.companimal.kakaoPay.model.dto.ReadyDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.java.Log;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.LinkedHashMap;
import java.util.Map;

@Log
@Service
public class KakaoPay {

    // 결제를 하기 위해서 결제 정보를 kakaopay server에 전달하고 결제 고유번호 (TID)와 URL을 응답받는 단계이다.
    private ReadyDTO readyDTO;                     // 결제 준비
    private ApproveDTO approveDTO;                 // 결제 승인 요청
    private static final ObjectMapper mapper = new ObjectMapper();
    private HttpHeaders header() {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "SECRET_KEY DEVDBAB0A42804808880722C0AA6AA528BD47A2C"); // kakao 홈페이지에 있는 admin key
        headers.add("Content-Type", "application/json;charset=UTF-8");
        return headers;
    }

    public KakaoPay() {
        this.readyDTO = new ReadyDTO();
    }

    public String kakaoPayReady() {

        /* 결제 요청을 하기 위해서 제출을 해야할 정보들이 있다.
         * 1. header -> (POST, HOST (url 주소), AUTHORIZATION (권한), CONTENT-TYPE)
         * 2. body -> (cid, cid_secret, ...)
         * 이런 정보들을 보내야 하기 때문에 POST 방식으로 작성을 해서 -> https://kapi.kakao.com 으로 보낸다
         * */

        RestTemplate restTemplate = new RestTemplate(); // restTempate을 사용해서 kakaopay data를 보내는 방법이다. request (요청)을 받을 때 까지 기달린다


            /* URL address = new URL("https://open-kapi.kakao.com/online/v1/payment/ready");
            HttpURLConnection connection = (HttpURLConnection) address.openConnection(); // 서버 연결
            connection.setRequestMethod("POST");                                         // 보낸다
            connection.setRequestProperty("Authorization", "SECRET_KEY " + "fb640a13c9c7ad443e512c455ae49116"); // admin key
            connection.setRequestProperty("Content-type", "application/json");
            connection.setDoOutput(true); // 서버한테 전달할게 있는지 없는지 */
        /* Header 내용들 */
        /* headers.add("Accept", MediaType.APPLICATION_JSON_UTF8_VALUE);
        headers.add("Content-Type",MediaType.APPLICATION_FORM_URLENCODED_VALUE + ";charset=UTF-8");
        headers.add("Content-Type","application/json;charset=UTF-8"); */

        /* 서버로 요청할 Body */

        Map<String, Object> params = new LinkedHashMap<>();
        params.put("cid", "TC0ONETIME");                                     // 가맹점 코드
        params.put("partner_order_id", "1001");                              // 가맹점 주문번호
        params.put("partner_user_id", "jeehwan");                             // 가맹점 회원 id
        params.put("item_name", "macbook");                                   // 상품명을 넣으면 된다
        params.put("quantity", 1);                                           // 상품 수량 (int)
        params.put("total_amount", 2100);                                    // 총 금액   (int)
        params.put("tax_free_amount", 100);                                  // 상품 비과세 금액 (int)
        params.put("approval_url", "http://localhost:8080/kakaoPaySuccess");  // 결제 성공 시 redirect url
        params.put("cancel_url", "http://localhost:8080/kakaoPayCancel");    // 결제 취소 시 redirect url
        params.put("fail_url", "http://localhost:8080/kakaoPayFail");        // 결제 취소 시 redirect url

        String parameter = null;
        try {
            parameter = mapper.writeValueAsString(params);  // 정보를 내보낼 때 모두 다 String형변환을 해야하기 때문에 params을 String형변환을 해준다
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

        /* header와 body를 붙이는 방법이다 */
        HttpEntity<String> body = new HttpEntity<>(parameter, header()); // 나중에 같이 보내기 위해서 headers + params 합친다



        System.out.println(body); // 잘 붙었는지 확인

        readyDTO = restTemplate.postForObject("https://open-api.kakaopay.com/online/v1/payment/ready", body, ReadyDTO.class);
        log.info("" + readyDTO); // 받은 정보를 String 값으로 변환을 해준다
        /* System.out.println(readyDTO.getNext_redirect_pc_url());
            System.out.println(readyDTO.getTid());
            System.out.println(readyDTO.getCreated_at()); */
        return readyDTO.getNext_redirect_pc_url(); // redirect url을 불러와 결제가 완료되면 해당 주소로 가게끔 설정함

        /* } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } */

        /* OutputStream send = connection.getOutputStream();                // 정보를 보낸다
            DataOutputStream dataSend = new DataOutputStream(send);
            dataSend.writeBytes(params.toString());                             // String으로 형변환을 해서 정보 전달 (byte로 형변환을 해서 보내야한다)
            dataSend.close();                                                   // 보내고 비운다

            int result = connection.getResponseCode();                          // 전송이 잘 됐는지 안됐는지 번호를 받는다.
            InputStream receive; // 받는다

            if(result == 200) { // HTML에서 정상적인 통신은 200을 뜻하고, 그 외 숫자들은 다 error를 뜻한다
                receive = connection.getInputStream();
            } else {
                receive = connection.getErrorStream();
            }

            InputStreamReader read = new InputStreamReader(receive);             // 받은 정보를 읽는다
            BufferedReader change = new BufferedReader(read);

            return change.readLine(); */
        /* 앞서 설명했듯이, 성공적으로 정보를 보냈으면, kakaopay에서 응답정보를 보내준다.
         *  응답정보를 담을 객체를 새로 만든다 (KakaoPayReadyVO) */
//        try {

        // restTemplate을 이용해서 kakaoPay에서 받을 정보들을 ReadyDTO로 저장한다
//            String redirectUrl = readyDTO.getNext_redirect_pc_url();

//            return "/pay";
    }

    public ApproveDTO kakaoPayInfo (String pg_token) {

        RestTemplate restTemplate = new RestTemplate();

        // 인증 완료시 응답 받는 pg_token + tid로 최종 승인요청을 합니다
        // 결제 승인 요청이 실패하면 카드사 등 결제 수단의 실패 정보들이 필요하기 때문에 포함될 수 있습니다.
        /* 서버로 요청할 Header */


        /* 서버로 요청할 Body */
        Map<String, Object> params = new LinkedHashMap<>();
        // total_amount 빼고 다 String 형식이다
        params.put("cid","TC0ONETIME");         // 가맹점 코드
        params.put("tid",readyDTO.getTid());    // 결제 고유번호
        params.put("partner_order_id","1001");  // 가맹점 주문번호
        params.put("partner_user_id","jeehwan");   // 가맹점 회원 id
        params.put("pg_token", pg_token);       // 결제승인 요청을 인증하는 token

        String parameters = null;
        try {
            parameters = mapper.writeValueAsString(params);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

        HttpEntity<String> body = new HttpEntity<>(parameters, header()); // 나중에 같이 보내기 위해서 headers + params 합친다
        System.out.println(body);

        approveDTO = restTemplate.postForObject("https://open-api.kakaopay.com/online/v1/payment/approve", body, ApproveDTO.class);
        log.info("" + approveDTO);
        System.out.println(approveDTO.toString());
        log.info("" + approveDTO); // 받은 정보들을 String으로 형변환을 한다

        return approveDTO;
    }
}

