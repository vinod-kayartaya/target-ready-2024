import React, { Component } from 'react';
import { Link } from 'react-router-dom';

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
        <div className='container'>
          <Link className='btn btn-link' to='/'>
            Home
          </Link>{' '}
          |
          <Link className='btn btn-link' to='/add-expense'>
            Add expense
          </Link>{' '}
          |
          <Link className='btn btn-link' to='/expenses'>
            View expenses
          </Link>{' '}
          |
          <Link className='btn btn-link' to='/about'>
            About
          </Link>
        </div>
      </>
    );
  }
}

export default Header;
