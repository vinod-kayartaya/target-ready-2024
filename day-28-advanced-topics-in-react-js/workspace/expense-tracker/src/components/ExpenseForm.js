import React, { useEffect, useRef, useState } from 'react';
import { useExpensesContext } from '../custom-hooks';

const currentDate = () => {
  // Get current date
  var currentDate = new Date();

  // Define options for formatting
  var options = { day: '2-digit', month: '2-digit', year: 'numeric' };

  // Create formatter
  var dateFormatter = new Intl.DateTimeFormat('en-IN', options);

  // Format the date
  return dateFormatter.format(currentDate);
};

const ExpenseForm = () => {
  const { addExpense, expenseToEdit, setExpenseToEdit, updateExpense } =
    useExpensesContext();
  const descriptionRef = useRef();

  const [data, setData] = useState({
    description: '',
    amount: 0,
    date: currentDate(),
  });

  useEffect(() => {
    if (expenseToEdit !== null) {
      setData(expenseToEdit);
    }
  }, [expenseToEdit]);

  const changeHandler = ({ target: { name, value } }) => {
    setData({ ...data, [name]: value });
  };

  const cancelButtonHandler = () => {
    setData({
      description: '',
      amount: 0,
      date: currentDate(),
    });
    setExpenseToEdit(null);
  };

  const submitHandler = (evt) => {
    evt.preventDefault(); // prevent submission of form to the server (action attribute)

    if (data.description.trim().length === 0) return;

    if (expenseToEdit === null) {
      addExpense(data);
      descriptionRef.current.focus();
    } else {
      updateExpense(data);
    }

    setData({
      description: '',
      amount: 0,
      date: currentDate(),
    });
  };

  return (
    <>
      {expenseToEdit ? (
        <h3>Update expense details</h3>
      ) : (
        <h3>Add new expense details</h3>
      )}

      <form onSubmit={submitHandler} className='mb-3'>
        <div className='mb-3'>
          <label htmlFor='descriptionInput' className='form-label'>
            Description
          </label>
          <input
            type='text'
            className='form-control'
            id='descriptionInput'
            value={data.description}
            onChange={changeHandler}
            name='description'
            ref={descriptionRef}
          />
        </div>
        <div className='mb-3'>
          <label htmlFor='amountInput' className='form-label'>
            Amount
          </label>
          <input
            type='number'
            className='form-control'
            id='amountInput'
            value={data.amount}
            onChange={changeHandler}
            name='amount'
          />
        </div>
        <div className='mb-3'>
          <label htmlFor='dateInput' className='form-label'>
            Date (DD/MM/YYYY) </label>
          <input
            type='text'
            className='form-control'
            id='dateInput'
            value={data.date}
            onChange={changeHandler}
            name='date'
          />
        </div>
        <button type='submit' className='btn btn-primary'>
          {expenseToEdit ? 'Update' : 'Add'}
        </button>
        <button
          onClick={cancelButtonHandler}
          type='button'
          className='btn btn-link text-danger'
        >
          Cancel
        </button>
      </form>
    </>
  );
};

export default ExpenseForm;
