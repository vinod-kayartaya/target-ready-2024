import React, { useState } from 'react';
import Header from './components/Header';
import Footer from './components/Footer';
import ExpenseForm from './components/ExpenseForm';
import ExpenseList from './components/ExpenseList';
import ExpensesProvider from './ExpensesProvider';

const App = () => {
  return (
    <>
      <ExpensesProvider>
        <Header />
        <div style={{ minHeight: '650px' }} className='container'>
          <div className='row'>
            <div className='col-md-6 col-xs-12'>
              <ExpenseForm />
            </div>

            <div className='col-md-6 col-xs-12'>
              <ExpenseList />
            </div>
          </div>
        </div>
        <Footer />
      </ExpensesProvider>
    </>
  );
};

export default App;
