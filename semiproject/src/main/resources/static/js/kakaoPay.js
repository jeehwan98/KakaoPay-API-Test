/* Jquery ajax 사용 */

$(function(){
    $('#apibtn').click(function(){
        $.ajax({
            url:'kakaopay',
            dataType:'json',
            success:function(data){
                alert(resp.tid); //결제 고유 번호
                var box = data.next_redirect_pc_url;
                window.open(box); // 새창 열기
                location.href = box;
            },
            error:function(error){
                alert(error);
            }
        });
    });
});