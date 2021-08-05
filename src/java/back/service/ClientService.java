/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package back.service;

import back.dao.ClientDao;
import back.bean.Client;

/**
 *
 * @author a
 */
public class ClientService {

    public ClientDao clientDao = new ClientDao();

    public Object[] seCOnnnecter(String username, String password) {
        Client client = clientDao.findByLogin(username);
       int res=0;
        if (client == null) {
            res= -1;
        } else if (client.getPassword().equals(password)) {
            res= -2;
        } else {
            res= 1;
        }
        return new Object[]{res,client};
    }
}
