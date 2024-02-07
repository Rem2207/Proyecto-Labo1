package service;

import controller.Admin;
import model.DAOAdmin;
import model.DAOException;

public class AdminService {
    private DAOAdmin daoAdmin;

    public AdminService() {
        daoAdmin =new DAOAdmin();
    }
    public void guardar(Admin admin) throws ServiceException {
        try {
            daoAdmin.guardar(admin);
        } catch (DAOException e) {
            throw new ServiceException(e.getMessage());
        }
    }
    public void eliminar(int DNI) throws ServiceException
    {
        try{
            daoAdmin.eliminar(DNI);
        }
        catch (DAOException e)
        {
            throw  new ServiceException(e.getMessage());
        }
    }

    public Admin buscar(int DNI)throws  ServiceException
    {
        Admin  admin=null;
        try {
            admin=daoAdmin.buscar(DNI);
        }
        catch (DAOException e)
        {
            throw new ServiceException(e.getMessage());
        }
        return admin;
    }
}

