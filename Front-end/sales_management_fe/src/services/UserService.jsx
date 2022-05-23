import axios from "axios";


class UserService{
    checkToken() {
        return axios(
            {
                url: `/checkToken`,
                method: "get",
                baseURL: "http://localhost:8080",
                headers: {
                    "Authorization": `Bearer ${localStorage.getItem("token")}`,
                }
            }
        );
    }


    createAccount(account){
        return axios.post("http://localhost:8080/register", account);
    }

    checklogin(account){
        return axios.post("http://localhost:8080/login",account);
    }

    getAccInfo(ourRequest) {
        return axios(
            {
                url: `/getUserInfo/${localStorage.getItem("accid")}`,
                method: "get",
                baseURL: "http://localhost:8080",
                headers: {
                    "Authorization": `Bearer ${localStorage.getItem("token")}`,
                },
                cancelToken: ourRequest.token
            }
        );
    }
    changeAccInfo(updatedInfo) {
        return axios(
            {
                url: `/changeAccInfo/${localStorage.getItem("accid")}`,
                method: "put",
                baseURL: "http://localhost:8080",
                headers: {
                    "Authorization": `Bearer ${localStorage.getItem("token")}`,
                },
                data: updatedInfo
            }
        );
    }

    changePass(pass) {
        return axios(
            {
                url: `/changeAccPass/${localStorage.getItem("accid")}`,
                method: "put",
                baseURL: "http://localhost:8080",
                headers: {
                    "Authorization": `Bearer ${localStorage.getItem("token")}`,
                },
                data: pass
            }
        );
    }

    block(id){
        return axios.put("http://localhost:8080/blockAcc/" + id);
    }
   
}

export default new UserService()