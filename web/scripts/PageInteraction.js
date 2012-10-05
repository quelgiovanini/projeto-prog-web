$(function(){
    $("#linkCadastrarPessoa").button({icons: { primary: "ui-icon-gear"},text:false});
    $("#dialog").dialog({
        autoOpen:false,
        width: 700,
        height: 350,
        resizable: false,
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

