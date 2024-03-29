<%@ page import="mapping.Table" %>
<div class="card">
    <div class="card-body">
        <h4 class="card-title">Inserer</h4>
        <p class="card-description"> Table</p>
        <form class="forms-sample" action="insererTable" method="post">

            <%
                if (request.getAttribute("tab")!=null) {
                    Table temp= (Table) request.getAttribute("tab");
            %>
            <input type="hidden" name="id" value="<%=temp.getIdtable()%>">
            <div class="form-group row">
                <label for="nomidmodif" class="col-sm-3 col-form-label">Nom</label>
                <div class="col-sm-9">
                    <input type="text" class="form-control" id="nomidmodif" placeholder="Nom..." name="nom" value="<%=temp.getNom()%>">
                </div>
            </div>

            <%
            }else {
            %>

            <div class="form-group row">
                <label for="nomid" class="col-sm-3 col-form-label">Nom</label>
                <div class="col-sm-9">
                    <input type="text" class="form-control" id="nomid" placeholder="Nom..." name="nom">
                </div>
            </div>

            <%
                }
            %>


            <input type="submit" class="btn btn-primary mr-2" value="Enregistrer">
        </form>
    </div>
</div>