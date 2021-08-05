<%-- 
    Document   : Login
    Created on : 15 mai 2020, 12:49:00
    Author     : a
--%>

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
        </title>


    </head>
    <body>
        

            <form method="post" action="ClientControler">

                <div class="container center">

                <h4 class="mb-3">Connectez-vous</h4>
                <div class="col-md-4">
                    <label for="firstName">Username</label>
                    <input type="text" class="form-control" id="id" name="username" autocomplete="off"  placeholder="">

                </div>
                <div class="col-md-4">
                    <label for="firstName">password</label>
                    <input type="password" class="form-control" id="firstName" name="password" autocomplete="off"  placeholder="">

                </div>

                </br>
                <button class="btn btn-primary btn-lg " type="submit"  name="connect">
                    connecter
                </button>

                </div>
            </form>

    </body> 
</html>