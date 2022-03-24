import React,{useCallback, useEffect, useState} from 'react';
import { useNavigate } from "react-router-dom";
import UserService from '../services/UserService';
function LoginComponent() {
    let navigate=useNavigate();
    const[username,setUsername]=useState("");
    const[password,setPassword]=useState("");
    const[error,setError]=useState("");
    const login=useCallback((e)=>{
        e.preventDefault();
        let acc={
            username:username,
            password:password
        }
        console.log(acc);
        if(username==="")
            setError("Vui long nhap username !!!")
        else if(password==="")
            setError("Vui long nhap password !!!")
        else {
            UserService.checklogin(acc).then(res=>{
                console.log(res.data);
                if(res.data.status!==401){
                    localStorage.setItem("token",res.data.token);
                    localStorage.setItem("accid",res.data.acc.id);
                    localStorage.setItem("username",res.data.acc.username);
                    localStorage.setItem("role",res.data.acc.authorities[0].authority)
                    localStorage.setItem("accid",res.data.acc.id)
                    navigate('/home');
                } else if(res.data.message==="User account is locked"){
                    setError("Username da bi khoa !!!!");
                } else {
                    setError("Username hoac password ko dung !!!!");
                }
            });
        }
    
    },[username,password]);
    const enterUsername=(e)=>{
        setUsername(e.target.value);
    }
    const enterPassword=(e)=>{
        setPassword(e.target.value);
    }
    const register=useCallback(()=>navigate('/register'),[navigate]);
    return(
        
        <div>
                <br></br>
                <div className='container'>
                    <div className='row'>
                        <div className = "card col-md-6 offset-md-3 offset-md-3">
                            <h3 className="text-center"> Login </h3>
                            <label style={{color:"orange",textAlign:"center"}}>{error}</label>
                            <div className="card-body">
                                <form>
                                    <div className="form-group" style={{textAlign:"left"}}>
                                        <label >User name: </label> <br></br>
                                        <input type="text" placeholder="Username" value={username} onChange={enterUsername} className='form-control'/>
                                        <br></br>
                                    </div>

                                    <div className='form-group' style={{textAlign:"left"}}>
                                        <label>Password: </label><br></br>
                                        <input type="password" placeholder="Password" value={password} onChange={enterPassword} className='form-control'/>
                                        <br></br>
                                    </div>
                                    
                                    <button className="btn btn-success" onClick={login} style={{width: "100%"}}>LOGIN</button>
                            
                                    <div style={{textAlign:"left"}}>
                                    New user <button className="btn btn-link" onClick={register} >Register here</button>
                                    </div>
                                </form>

                            </div>
                        </div>

                    </div>
                </div>
            </div>
    );
}

export default LoginComponent;