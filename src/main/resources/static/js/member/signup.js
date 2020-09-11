$(function () {
    $('#join-submit').click(function () {
        var pw1 = $('#inputPassword').val();
        var pw2 = $('#inputPasswordCheck').val();
        var name = $('#inputName').val();
        var user_id = $('#InputId').val();

        if(name.length==0){
            alert("이름을 입력해주세요");
        }
        else if(user_id.length<5 || user_id.length>15){
            alert("아이디는 5글자이상 14글자 이하로 해주세요");
        }
        else if(pw1 !== pw2){
            alert("비밀번호가 일치하지 않습니다");
        }
        else if(pw1.length<8 || pw2.length<8){
            alert("비밀번호는 8자 이상으로 해주세요");
        }
        else{
            var data = {
                'name': $('#inputName').val(),
                'userId': $('#InputId').val(),
                'password': $('#inputPassword').val()
            }
            $.ajax({
                type: 'POST',
                url: '/member/signup',
                dataType: 'json',
                contentType: 'application/json ; charset=utf-8',
                data: JSON.stringify(data),
            }).done(function () {
                alert("회원가입이 완료 됐습니다")
                window.location.href = "/";
            }).fail(function (error) {
                alert(error);
            })
        }
    })
})