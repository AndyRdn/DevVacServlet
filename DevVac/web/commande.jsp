<%@ page import="java.util.Vector" %>
<%@ page import="mapping.Commande" %>


<%
    Vector<Commande> cmd= (Vector<Commande>) request.getAttribute("commande");
%>

<div class="card">
    <div class="card-body">
        <h4 class="card-title">Tous les Commande</h4>
        </p>
        <div class="table-responsive">
            <table class="table">
                <thead>
                <tr>
                    <th>Id Commande</th>
                    <th>Id sakafo</th>
                    <th>Id table</th>
                    <th>Id employer</th>
                    <th>Date Time</th>
                    <th>montant</th>
                    <th>Modifier</th>
                    <th>Suprimer</th>
                </tr>
                </thead>
                <tbody>
                <%
                    for (int i = 0; i <cmd.size() ; i++) {

                %>
                <tr>
                    <td><%=cmd.get(i).getIdCommande()%></td>
                    <td><%=cmd.get(i).getIdPlat()%></td>
                    <td><%=cmd.get(i).getIdTable()%></td>
                    <td><%=cmd.get(i).getIdEmployer()%></td>
                    <td><%=cmd.get(i).getDateT()%></td>
                    <td><%=cmd.get(i).getMontant()%></td>
                    <td> <a href="insererCommande?action=update&id=<%=cmd.get(i).getIdCommande() %>"><button type="button" class="btn btn-inverse-warning btn-fw">Modifier</button></a></td>
                    <td><a href="insererCommande?action=del&id=<%=cmd.get(i).getIdCommande() %>"><button type="button" class="btn btn-inverse-danger btn-fw">Suprimer</button></a></td>
                </tr>
                <%
                    }
                %>
                </tbody>
            </table>
        </div>
    </div>
</div>