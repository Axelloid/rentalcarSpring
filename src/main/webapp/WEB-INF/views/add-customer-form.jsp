<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<html>
<head>
    <title>Inserimento customer</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
  <div class="container-fluid">
      <h2>Aggiungi utente</h2>

      <c:url var="addAction" value="/utente/addCustomer/save"></c:url>
      <form:form action="${addAction}">
          <div class="form">

              <div class="form-group">
                  <label <%--for="nome"--%>>Nome</label>
                  <%--<form:input id="nome" path="nome" type="text" class="form-control"/>--%>
              </div>

              <div class="form-group">
                  <label <%--for="cognome"--%>>Nome</label>
                  <%--<form:input id="cognome" path="cognome" type="text" class="form-control"/>--%>
              </div>

              <div class="form-group">
                  <label <%--for="datadinascita"--%>>Data di nascita</label>
                  <%--<form:input id="datadinascita" path="datadinascita" type="date" class="form-control"/>--%>
              </div>

              <div class="form-group">
                  <label <%--for="ruolo"--%>>Ruolo</label>
                  <%--<form:input id="ruolo" path="ruolo" type="text" class="form-control" value="customer"/>--%>
              </div>

              <div class="form-actions">
                  <input type="submit" id="btnSave" class="btn btn-success form-buttons" value="Save"/>
                  <button type="button" class="btn btn-danger form-buttons" onclick="history.back()">Back</button>
              </div>
          </div>
      </form:form>
  </div>
</body>
</html>