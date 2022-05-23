import React from "react";
import { useState } from 'react';
import { useNavigate, useHistory, useParams } from "react-router-dom";
import { useEffect } from 'react';
import ProductService from "../services/ProductService";

import HeaderComponent from "./HeaderComponent";
function ViewProductComponent(props){
    // let navigate=useNavigate();
    let history = useHistory;
    let {id} = useParams();
    
    const[result,setResult]=useState([]);

    useEffect(()=>{
        ProductService.getProductById(id).then(res=>{
           
                setResult(res.data);}
        );
       
    },[result]);
    

    // componentDidMount=() =>{
    //     ProductService.getProductById(props.match.params.id).then( res =>{
    //         this.setState({product: res.data});
    //     })
    // }

    return(
        <div >
            {/* <HeaderComponent/> */}
            <table style={{border:"none", marginLeft: "2%", marginRight:"2%"}}>
                <td style={{width:"50%"}}>
                {    

                        result.map(
                            product=>   
                            <div key={product.id} className="col-sm-4" style={{textAlign: "center", height: "360px"}}>
                               
                                <img src={product.image} style={{height: "300px"}} alt="image"/><br></br> 
                                {/* <b>{product.name}</b><br></br>
                                {product.price} VNĐ<br></br>  */}
                            </div>
                        )
                         } 
                

                </td>
                <td style={{width:"50%", textAlign:"left"}}>
                    <h2 className="text-center">Employees List</h2>
                    <div>
                        <button className="btn btn-primary"  style={{width:"100%"}}> Mua ngay</button>
                        <h6>PHÍ VẬN CHUYỂN TOÀN QUỐC</h6>
                        <h6>ĐỔI TRẢ MIỄN PHÍ</h6>
                        <p>Hỗ trợ dổi trả sản phẩm trong vòng 3 đến 5 ngày, nếu không vừa size, sản phẩm bị lỗi (giữ sản phẩm sạch và chưa qua sử dụng) bạn sẽ đổi hoặc trả sản phẩm mà không tốn phí.</p>
                        <h6>THANH TOÁN</h6>
                    </div>
                    <br></br>

                </td>

            </table>
        </div>

    );

}

export default ViewProductComponent;