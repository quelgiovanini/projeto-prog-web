$(function(){
    $("#linkCadastrarPessoa").button({icons: { primary: "ui-icon-gear"},text:false});
    $("#dialog").dialog({
        autoOpen:false,
        width: 400,
        height: 400,
        title: "Cadastrar Pessoa",
        modal: true
    });
    //alert("it does work");
    $("#linkCadastrarPessoa").click(function(e){
        e.preventDefault();
        $.ajax({
            url: "cadastraPessoas.html",
            success: function(data){
                $("#dialog").html(data);
                $("#dialog").dialog("open");
            }
        });
    });
  });

