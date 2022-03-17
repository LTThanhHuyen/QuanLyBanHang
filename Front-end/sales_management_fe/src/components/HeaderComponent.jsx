import React, { Component } from 'react';
import 'bootstrap';


class HeaderComponent extends Component {

    constructor(props){
        super(props)

        this.state = {
            
        }
    }
    
    render() {
        return (
            <div>
                <header className='header'>
                    <div className='header-1'>
                    {/* <form class="navbar-form navbar-left" action="Admin_trangchuController">
                    <div class="input-group">
                    <input type="text" name="key"  class="form-control" placeholder="Nhập từ khóa"></input>
                        <div class="input-group-btn">
                        <button class="btn btn-default" type="submit">
                            <i class="glyphicon glyphicon-search"></i>
                        </button>
                        </div>
                    </div>
                    </form>		 */}

                    <a href="/">  Sheeko </a>
                    <form action="" class="search-form">
                        <input type="search" name="" placeholder="search here..." ></input>
                        <label for="search-box" class="fas fa-search"></label>
                    </form>

                    <div class="icons">
                        <div id="search-btn" class="fas fa-search"></div>
                        
                        <div   class="fas fa-user">Đăng nhập</div>
                        <div  class="fas fa-user">Đăng ký</div>
                    </div>
                    </div>
                </header>
                
            </div>
        );
    }
}

export default HeaderComponent;