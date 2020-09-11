$(function () {
    $('#btn-save').click(function () {
        var data ={
            author : $('#author').val(),
            title : $('#title').val(),
            content : $('#content').val(),
        }

        $.ajax({
            type: 'POST',
            url : '/postSave',
            dataType : 'json',
            contentType :'application/json ; charset=utf-8',
            data : JSON.stringify(data),
        }).done(function () {
            alert("글이 등록되었습니다");
            window.location.href = "/postMain"
        }).fail(function (error) {
            alert(error);
        })
    })
})
