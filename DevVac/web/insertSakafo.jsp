<%@ page import="mapping.Sakafo" %>
<div class="card">
    <div class="card-body">
        <h4 class="card-title">Inserer</h4>
        <p class="card-description"> Sakafo</p>
        <form class="forms-sample" action="insererSakafo" method="post">

            <%
                if (request.getAttribute("emp")!=null) {
                    Sakafo temp= (Sakafo) request.getAttribute("emp");
            %>
            <input type="hidden" name="id" value="<%=temp.getIdSakafo()%>">
            <div class="form-group row">
                <label for="nomidmodif" class="col-sm-3 col-form-label">Nom</label>
                <div class="col-sm-9">
                    <input type="text" class="form-control" id="nomidmodif" placeholder="Nom..." name="nom" value="<%=temp.getNom()%>">
                </div>
            </div>

            <div class="form-group row">
                <label for="prixidmodif" class="col-sm-3 col-form-label">Prix</label>
                <div class="col-sm-9">
                    <input type="number" class="form-control" id="prixidmodif" placeholder="Prix..." name="prix" value="<%=temp.getPrix()%>">
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

            <div class="form-group row">
                <label for="prixid" class="col-sm-3 col-form-label">Prix</label>
                <div class="col-sm-9">
                    <input type="number" class="form-control" id="prixid" placeholder="Prix..." name="prix">
                </div>
            </div>
            <%
                }
            %>


            <input type="submit" class="btn btn-primary mr-2" value="Enregistrer">
        </form>
    </div>
</div>