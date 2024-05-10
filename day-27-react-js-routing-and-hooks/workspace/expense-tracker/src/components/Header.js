import React, { Component } from 'react';

class Header extends Component {
  render() {
    return (
      <>
        <div className='alert alert-primary'>
          <div className='container'>
            <h1>
              <i className='bi bi-piggy-bank me-3'></i>
              <span>Expense Tracker</span>
            </h1>
          </div>
        </div>
      </>
    );
  }
}

export default Header;
