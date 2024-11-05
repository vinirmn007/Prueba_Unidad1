package com.prueba1.controls.dao;

import com.prueba1.controls.dao.implement.AdapterDao;
import com.prueba1.list.LinkedList;
import com.prueba1.models.Operacion;
import com.prueba1.stack.Stack;

public class OperacionDao extends AdapterDao<Operacion> {
    private Operacion operacion;
    private LinkedList listAll;

    public OperacionDao() {
        super(Operacion.class);
    }

    public Operacion getOperacion() {
        if (this.operacion == null) {
            this.operacion = new Operacion();
        }
        return this.operacion;
    }

    public void setOperacion(Operacion operacion) {
        this.operacion = operacion;
    }

    public LinkedList getListAll() {
        if (this.listAll == null) {
            this.listAll = listAll();
        }
        return this.listAll;
    }

    public void setListAll(LinkedList listAll) {
        this.listAll = listAll;
    }

    public Boolean save() throws Exception {
        Integer id = getListAll().getSize() +1;
        try {
            this.operacion.setId(id);
            this.persist(this.operacion);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public Boolean update() throws Exception {
        try {
            this.merge(this.operacion, this.operacion.getId()-1);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /*public transformacion() {
        Stack PT;
        Stack PS;
        
    }*/
}
