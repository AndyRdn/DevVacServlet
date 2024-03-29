<%@ page import="java.util.Vector" %>
<%@ page import="mapping.Sakafo" %>


<%
    Vector<Sakafo> skf= (Vector<Sakafo>) request.getAttribute("sakafo");
%>

<div class="card">
    <div class="card-body">
        <h4 class="card-title">Tous les Sakafo</h4>
        <form action="allSakafo" method="post">
            <div class="form-group row">
                <div class="col">
                    <label>Nom</label>
                    <div id="Nom">
                        <span class="twitter-typeahead" style="position: relative; display: inline-block;"><input type="text" class="form-control" name="nom"></span>
                    </div>
                </div>

                <div class="col">
                    <label>Prix Min</label>
                    <div id="Prixmin">
                        <span class="twitter-typeahead" style="position: relative; display: inline-block;"><input type="number" class="form-control" name="prixmin"></span>
                    </div>
                </div>

                <div class="col">
                    <label>Prixmax</label>
                    <div id="Prixmax">
                        <span class="twitter-typeahead" style="position: relative; display: inline-block;"><input type="number" class="form-control" name="prixmax"></span>
                    </div>
                </div>

                <div class="col">
                    <span class="twitter-typeahead" style="position: relative; display: inline-block;"><input type="submit" class="btn btn-primary mb-2" value="Search"></span>
                </div>

            </div>
        </form>

        </p>
        <div class="table-responsivskfe">
            <table class="table">
                <thead>
                <tr>
                    <th>Id Sakafo</th>
                    <th>Nom</th>
                    <th>Prix</th>
                    <th>Modifier</th>
                    <th>Suprimer</th>
                </tr>
                </thead>
                <tbody>
                <%
                    for (int i = 0; i <skf.size() ; i++) {

                %>
                <tr>
                    <td><%=skf.get(i).getIdSakafo()%></td>
                    <td><%=skf.get(i).getNom()%></td>
                    <td><%=skf.get(i).getPrix()%></td>
                    <td> <a href="insererSakafo?action=update&id=<%=skf.get(i).getIdSakafo() %>"><button type="button" class="btn btn-inverse-warning btn-fw">Modifier</button></a></td>
                    <td><a href="insererSakafo?action=del&id=<%=skf.get(i).getIdSakafo() %>"><button type="button" class="btn btn-inverse-danger btn-fw">Suprimer</button></a></td>
                </tr>
                <%
                    }
                %>
                </tbody>
            </table>
        </div>
    </div>
</div>