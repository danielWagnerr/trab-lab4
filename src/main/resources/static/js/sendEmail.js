$('#enviarMensagem').on('submit', (ev) => {
    ev.preventDefault()

    Swal.fire({
        title: '<strong>Enviando mensagem!</strong>',
        type: 'info',
        showCloseButton: false,
        showCancelButton: false,
        showConfirmButton: false,
        focusConfirm: false,
        confirmButtonText:
            'Ok',
        confirmButtonAriaLabel: 'Thumbs up, great!',
    })

    var baseUrl = window.location.origin;
    var nome = $("#nome").val()
    var msg = $('#mensagem').val()
    var contato = $('#contato').val()

    $.ajax({
        url: baseUrl + '/email/enviarEmail',
        crossDomain: true,
        type: 'post',
        dataType: 'text',
        contentType: 'application/json; charset=utf-8',
        data: {
            nome: nome,
            assunto: assunto,
            mensagem: msg,
            contato: contato
        },
        success: (data) => {
            console.log(data)
            const Toast = Swal.mixin({
                toast: true,
                position: 'center',
                showConfirmButton: false,
                timer: 3000
            })

            Toast.fire({
                type: 'success',
                title: 'Mensagem enviada!'
            })
            $('form')[0].reset();
        },
        error: () => {
            const Toast = Swal.mixin({
                toast: true,
                position: 'center',
                showConfirmButton: false,
                timer: 4000
            })

            Toast.fire({
                type: 'error',
                title: 'Mensagem não enviada, ocorreu um problema desconhecido!'
            })
            $('form')[0].reset();
        }
    })
})