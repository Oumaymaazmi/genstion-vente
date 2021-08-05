<%-- 
    Document   : PanierValidation
    Created on : 18 mai 2020, 00:19:03
    Author     : a
--%>
<%@page import="back.bean.Panier"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" http-equiv ="refresh">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta name="description" content="">
        <meta name="author" content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
        <meta name="generator" content="Jekyll v3.8.6">
        <title>
            Welcome
        </title>


    </head>
    <body>
       
            <form method="post" action="/gestiondeVente/PanierValidationControler" >

                <div class="container center">

                    <h4 class="mb-3">Valider</h4>
                    
                    <div class="col-md-4">
                        <label for="firstName">Nome</label>
                        <input type="text" class="form-control" id="id" name="Nom" autocomplete="off"  placeholder="">

                    </div>
                    <div class="col-md-4">
                        <label for="firstName">Prénom</label>
                        <input type="text" class="form-control" id="firstName" name="prenom" autocomplete="off"  placeholder="">

                    </div>
                    <div class="col-md-4">
                        <label for="firstName">Votre Adresse</label>
                        <input type="text" class="form-control" id="firstName" name="adress" autocomplete="off"  placeholder="">

                    </div>
                    
          
                    </br>
                    <button class="btn btn-primary btn-lg " type="submit"  name="enregister">
                        Enregistrer
                    </button>

                </div>
            </form>

    </body> 
</html>