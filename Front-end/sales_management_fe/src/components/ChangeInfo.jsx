import React, { useState, useEffect } from 'react';
import Form from 'react-bootstrap/Form';
import Button from 'react-bootstrap/Button';
import Card from 'react-bootstrap/Card';

import UserSV from '../services/UserService';
import { TailSpin } from 'react-loader-spinner';
import { useHistory } from 'react-router-dom';
import axios from "axios";
import Swal from 'sweetalert2'
import { motion } from "framer-motion"

function ChangeInfo(props) {

    // let navigate = useNavigate();
    let history = useHistory;

    const [loading, setLoading] = useState(false);

    const [name, setName] = useState("");

    const [phone, setPhone] = useState("");

    const [address, setAddress] = useState("");

    const [email, setEmail] = useState("");

    const [pass, setPass] = useState("");

    const [repass, setRepass] = useState("");

    const [update, setUpdate] = useState(false);

    const reload = () => { setUpdate(!update) }

    useEffect(() => {
        setLoading(true);
        const ourRequest = axios.CancelToken.source();
        setTimeout(async () => {
            await UserSV.getAccInfo(ourRequest).then(res => {
                if (res.data.status === 401) {
                    alert("session expired");
                    props.history.push("/")
                }
                setName(res.data.data.name);
                setPhone(res.data.data.phone);
                setEmail(res.data.data.email);                
                setAddress(res.data.data.address);
                
            })
            setLoading(false);
            return () => {
                ourRequest.cancel('Request is canceled by user');
            }
        }, 800);
    }, [update]);
   

    const changeName = (e) => {
        setName(e.target.value)
    }

    const changePhone = (e) => {
        setPhone(e.target.value)
    }
    const changeAddress = (e) => {
        setAddress(e.target.value)
    }

    const changePass = (e) => {
        setPass(e.target.value)
    }

    const changeRepass = (e) => {
        setRepass(e.target.value)
    }

    const changeInfo = () => {
        let info = {
            name: name,
            phone: phone,
            email: email,
            address: address
        }
        console.log(JSON.stringify(info));
        UserSV.changeAccInfo(info).then(res => {
            if (res.data.status === 401) {
                alert("Phi??n ????ng nh???p h???t h???n");
                props.history.push("/")
            }
            reload();
        })
        Swal.fire({
            icon: 'success',
            title: 'Thay ?????i m???t kh???u th??nh c??ng !!!!',
            showConfirmButton: false,
            timer: 1500
        })
    }

    const changeNewPass = () => {
        if (pass === "")
            Swal.fire({
                icon: 'error',
                title: 'Vui l??ng nh???p m???t kh???u m???i !!!!',
                showConfirmButton: false,
                timer: 1500
            })
        else if (repass === "")
            Swal.fire({
                icon: 'error',
                title: 'Vui l??ng nh???p l???i m???t kh???u m???i !!!!',
                showConfirmButton: false,
                timer: 1500
            })
        else if (pass !== repass) {
            Swal.fire({
                icon: 'error',
                title: 'M???t kh???u kh??ng tr??ng kh???p !!!!',
                showConfirmButton: false,
                timer: 1500
            })
            setPass("");
            setRepass("");
        } else {
            let updatedPass = {
                password: pass
            }
            UserSV.changePass(updatedPass).then(res => {
                if (res.data.status === 401) {
                    alert("Phi??n ????ng nh???p h???t h???n");
                    props.history.push("/")
                }
            });
            Swal.fire({
                icon: 'success',
                title: 'M???t kh???u ???? ???????c thay ?????i',
                showConfirmButton: false,
                timer: 1500
            })
            setPass("");
            setRepass("");
        }
    }

    return (
        <div style={{border:"none", marginLeft: "2%", marginRight: "2%"}}>

            <Card style={{ marginTop: "20px",  marginLeft: "25%", marginRight: "25%" }}>
                <Card.Header>
                    <div style={{ color: "red", fontSize: "30px" }}>Th??ng tin c?? nh??n</div>
                </Card.Header>
                <Card.Body>
                    <table style={{ width: "100%" }}>

                        <tr>
                            <td>
                                <Form style={{textAlign:"left"}}>
                                    <Form.Group className="mb-3" >
                                        <Form.Label >H??? t??n:</Form.Label>
                                        <Form.Control type="text" value={name} onChange={changeName} />
                                    </Form.Group>
                                    <Form.Group className="mb-3" >
                                        <Form.Label>S??? ??i???n tho???i:</Form.Label>
                                        <Form.Control type="text" value={phone} onChange={changePhone} />
                                    </Form.Group>
                                    <Form.Group className="mb-3" >
                                        <Form.Label>?????a ch???:</Form.Label>
                                        <Form.Control type="text" value={address} onChange={changeAddress} />
                                    </Form.Group>
                                    <fieldset disabled>
                                        <Form.Group className="mb-3" >
                                            <Form.Label>Email:</Form.Label>
                                            <Form.Control type="text" value={email} />
                                        </Form.Group>
                                    </fieldset>
                                    <Button variant="primary" onClick={changeInfo} style={{width: "100%"}}>
                                        Update
                                    </Button>
                                </Form>
                            </td>
                        </tr>
                    </table>


                </Card.Body>
            </Card>
            <Card style={{ marginTop: "25px", marginLeft: "25%", marginRight: "25%" }}>
                <Card.Header>
                    <div style={{ color: "red", fontSize: "30px" }}>Thay ?????i m???t kh???u</div>
                </Card.Header>
                <Card.Body>
                    <Form style={{textAlign:"left"}}>
                        <Form.Group className="mb-3">
                            <Form.Label>M???t kh???u m???i:</Form.Label>
                            <Form.Control type="password" value={pass} onChange={changePass} />
                        </Form.Group>
                        <Form.Group className="mb-3" >
                            <Form.Label>Nh???p l???i m???t kh???u:</Form.Label>
                            <Form.Control type="password" value={repass} onChange={changeRepass} />
                        </Form.Group>
                        <Button variant="primary" onClick={changeNewPass} style={{width: "100%"}}>
                            Change
                        </Button>
                    </Form>
                </Card.Body>
            </Card>
       
    </div>


        
    )
}
export default ChangeInfo;