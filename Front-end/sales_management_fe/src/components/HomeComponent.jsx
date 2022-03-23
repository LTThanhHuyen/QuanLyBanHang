import React, { Component } from 'react';
import ProductService from '../services/ProductService';

class HomeComponent extends Component {
    constructor(props){
        super(props)

        this.state = {
            products: []
            
        }
    }

    render() {
        return (
            <div>
                <div className='row'>
                {
                    this.state.products.map(
                        category => 
                        <div class="col-sm-4" style="text-align: center; height: 360px;">
                            {category.name}
                        </div>
                       
                    )
                }
                </div>
            </div>
        );
    }
}

export default HomeComponent;