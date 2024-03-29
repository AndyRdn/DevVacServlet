<%@ page import="mapping.Employer" %>
<div class="card">
    <div class="card-body">
        <h4 class="card-title">Inserer</h4>
        <p class="card-description"> Employer</p>
        <form class="forms-sample" action="insererEmployer" method="post">

            <%
                if (request.getAttribute("emp")!=null) {
                    Employer temp= (Employer) request.getAttribute("emp");
            %>
                <input type="hidden" name="id" value="<%=temp.getIdEmployer()%>">
                <div class="form-group row">
                    <label for="nomidmodif" class="col-sm-3 col-form-label">Nom</label>
                    <div class="col-sm-9">
                        <input type="text" class="form-control" id="nomidmodif" placeholder="Nom..." name="nom" value="<%=temp.getNom()%>">
                    </div>
                </div>

                <div class="form-group row">
                    <label for="ageidmodif" class="col-sm-3 col-form-label">Age</label>
                    <div class="col-sm-9">
                        <input type="number" class="form-control" id="ageidmodif" placeholder="Age..." name="age" value="<%=temp.getAge()%>">
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
                    <label for="ageid" class="col-sm-3 col-form-label">Age</label>
                    <div class="col-sm-9">
                        <input type="number" class="form-control" id="ageid" placeholder="Age..." name="age">
                    </div>
                </div>
            <%
                }
            %>


            <input type="submit" class="btn btn-primary mr-2" value="Enregistrer">
        </form>
    </div>
</div>