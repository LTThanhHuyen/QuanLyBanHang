import axios from "axios";


class UserService{

    createAccount(account){
        return axios.post("http://localhost:8080/register", account);
    }

    checklogin(account){
        return axios.post("http://localhost:8080/login",account);
    }

    changeAccInfo(user, user_id){
        return axios.put("http://localhost:8080/changeAccInfo/" + user_id, user);
    }

    block(id){
        return axios.put("http://localhost:8080/blockAcc/" + id);
    }
   
}

export default new UserService()