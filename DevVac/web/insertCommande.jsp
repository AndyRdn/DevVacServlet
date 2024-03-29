<%@ page import="java.util.Vector" %>
<%@ page import="mapping.Commande" %>
<%@ page import="mapping.Employer" %>
<%@ page import="mapping.Sakafo" %>
<%@ page import="mapping.Table" %><%
    Vector<Employer> emp= (Vector<Employer>) request.getAttribute("emp");
    Vector<Sakafo> skf= (Vector<Sakafo>) request.getAttribute("skf");
    Vector<Table> tbl= (Vector<Table>) request.getAttribute("tbl");
%>
<div class="card">
    <div class="card-body">
        <h4 class="card-title">Inserer</h4>
        <p class="card-description"> Commande</p>
        <form class="forms-sample" action="insererCommande" method="post">

            <%
                if (request.getAttribute("cmd")!=null) {
                    Commande temp= (Commande) request.getAttribute("cmd");
            %>
            <input type="hidden" name="id" value="<%=temp.getIdCommande()%>">
            <div class="form-group row">
                <label class="col-sm-3 col-form-label">Id Sakafo:</label>
                <div class="col-sm-9">
                    <select class="form-control" name="skf">
                        <%
                            for (int i = 0; i <skf.size() ; i++)
                            {
                                if (skf.get(i).getIdSakafo()==temp.getIdPlat())
                                { %>
                                    <option selected value="<%=skf.get(i).getIdSakafo()%>"><%=skf.get(i).getIdSakafo()%></option>
                                <%
                                }else
                                { %>
                                    <option value="<%=skf.get(i).getIdSakafo()%>"><%=skf.get(i).getIdSakafo()%></option>
                                <%
                                }%>
                        <%
                            }
                        %>
                    </select>
                </div>
            </div>

            <div class="form-group row">
                <label class="col-sm-3 col-form-label">Id Employer:</label>
                <div class="col-sm-9">
                    <select class="form-control" name="emp">
                        <%
                            for (int i = 0; i <skf.size() ; i++)
                            {
                                if (emp.get(i).getIdEmployer()==temp.getIdEmployer())
                                { %>
                        <option selected value="<%=emp.get(i).getIdEmployer()%>"><%=emp.get(i).getIdEmployer()%></option>
                        <%
                        }else
                        { %>
                        <option value="<%=emp.get(i).getIdEmployer()%>"><%=emp.get(i).getIdEmployer()%></option>
                        <%
                            }%>
                        <%
                            }
                        %>
                    </select>
                </div>
            </div>

            <div class="form-group row">
                <label class="col-sm-3 col-form-label">Id Table:</label>
                <div class="col-sm-9">
                    <select class="form-control" name="tbl">
                        <%
                            for (int i = 0; i <tbl.size() ; i++)
                            {
                                if (tbl.get(i).getIdtable()==temp.getIdTable())
                                { %>
                        <option selected value="<%=tbl.get(i).getIdtable()%>"><%=tbl.get(i).getIdtable()%></option>
                        <%
                        }else
                        { %>
                        <option value="<%=tbl.get(i).getIdtable()%>"><%=tbl.get(i).getIdtable()%></option>
                        <%
                            }%>
                        <%
                            }
                        %>
                    </select>
                </div>
            </div>

            <div class="form-group row">
                <label for="dateTtid" class="col-sm-3 col-form-label">Date Time</label>
                <div class="col-sm-9">
                    <input type="datetime-local" class="form-control" id="dateTtid" name="date" value="<%=temp.getDateT().toString()%>">
                </div>
            </div>

            <div class="form-group row">
                <label for="montantidmodif" class="col-sm-3 col-form-label">Montant</label>
                <div class="col-sm-9">
                    <input type="number" class="form-control" id="montantidmodif" placeholder="Montant..." name="montant" value="<%=temp.getMontant()%>">
                </div>
            </div>

            <%
            }else {
            %>
            <div class="form-group row">
                <label class="col-sm-3 col-form-label">Id Sakafo:</label>
                <div class="col-sm-9">
                    <select class="form-control" name="skf">
                        <%
                            for (int i = 0; i <skf.size() ; i++)
                            { %>
                                <option value="<%=skf.get(i).getIdSakafo()%>"><%=skf.get(i).getNom()%></option>
                        <%
                            }%>
                    </select>
                </div>
            </div>

            <div class="form-group row">
                <label class="col-sm-3 col-form-label">Id Employer:</label>
                <div class="col-sm-9">
                    <select class="form-control" name="emp">
                        <%
                            for (int i = 0; i <emp.size() ; i++)
                            { %>
                        <option value="<%=emp.get(i).getIdEmployer()%>"><%=emp.get(i).getNom()%></option>
                        <%
                            }%>
                    </select>
                </div>
            </div>

            <div class="form-group row">
                <label class="col-sm-3 col-form-label">Id Table:</label>
                <div class="col-sm-9">
                    <select class="form-control" name="tbl">
                        <%
                            for (int i = 0; i <tbl.size() ; i++)
                            { %>
                        <option value="<%=tbl.get(i).getIdtable()%>"><%=tbl.get(i).getNom()%></option>
                        <%
                            }%>
                    </select>
                </div>
            </div>

            <div class="form-group row">
                <label for="dateTtid" class="col-sm-3 col-form-label">Date Time</label>
                <div class="col-sm-9">
                    <input type="datetime-local" class="form-control" id="dateTtid" placeholder="Montant..." name="date">
                </div>
            </div>

            <div class="form-group row">
                <label for="montantid" class="col-sm-3 col-form-label">Montant</label>
                <div class="col-sm-9">
                    <input type="number" class="form-control" id="montantid" placeholder="Montant..." name="montant">
                </div>
            </div>
            <%
                }
            %>


            <input type="submit" class="btn btn-primary mr-2" value="Enregistrer">
        </form>
    </div>
</div>