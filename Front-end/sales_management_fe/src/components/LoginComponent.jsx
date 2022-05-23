import React,{useCallback, useEffect, useState} from 'react';
import { useNavigate , useHistory} from "react-router-dom";
import UserService from '../services/UserService';
import HeaderComponent from './HeaderComponent';
function LoginComponent(props) {
    // let navigate=useNavigate();
    let history = useHistory;
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
            setError("Vui lòng nhập tên đăng nhập!!!")
        else if(password==="")
            setError("Vui lòng nhập mật khẩu!!!")
        else {
            UserService.checklogin(acc).then(res=>{
                console.log(res.data);
                if(res.data.status!==401){
                    localStorage.setItem("token",res.data.token);
                    localStorage.setItem("accid",res.data.acc.id);
                    localStorage.setItem("username",res.data.acc.username);
                    localStorage.setItem("role",res.data.acc.authorities[0].authority)
                    localStorage.setItem("accid",res.data.acc.id)
                    // navigate('/home');
                    props.history.push('/home');
                } else if(res.data.message==="User account is locked"){
                    setError("Tài khoản đã bị khóa!!!!");
                } else {
                    setError("Tên đăng nhập hoặc mật khẩu không đúng!!!!");
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
    // const register=useCallback(()=>navigate('/register'),[navigate]);
    const register=useCallback(()=> props.history.push('/register'));
    
    return(
        
        <div>
            {/* <HeaderComponent/> */}
                <br></br>
                <div className='container'>
                    <div className='row'>
                        <div className = "card col-md-6 offset-md-3 offset-md-3">
                            <h3 className="text-center"> ĐĂNG NHẬP </h3>
                            <label style={{color:"orange",textAlign:"center"}}>{error}</label>
                            <div className="card-body">
                                <form>
                                    <div className="form-group" style={{textAlign:"left"}}>
                                        <label >Tên đăng nhập: </label> <br></br>
                                        <input type="text" placeholder="Tên đăng nhập" value={username} onChange={enterUsername} className='form-control'/>
                                        <br></br>
                                    </div>

                                    <div className='form-group' style={{textAlign:"left"}}>
                                        <label>Mật khẩu: </label><br></br>
                                        <input type="password" placeholder="Mật khẩu" value={password} onChange={enterPassword} className='form-control'/>
                                        <br></br>
                                    </div>
                                    
                                    <button className="btn btn-success" onClick={login} style={{width: "100%"}}>ĐĂNG NHẬP</button>
                            
                                    <div style={{textAlign:"left"}}>
                                    Tạo tài khoản mới <button className="btn btn-link" onClick={register} >Đăng ký tại đây</button>
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