import React from 'react';

const ExpenseItem = ({ expense, deleteExpense }) => {
  const deleteButtonHandler = () => {
    deleteExpense(expense.id);
  };

  return (
    <li className='list-group-item'>
      <p>
        {expense.date}
        <span className='ms-3 lead'>{expense.description}</span>

        <span className='float-end'>
          <button
            onClick={deleteButtonHandler}
            className='btn btn-link bi bi-x-circle-fill text-danger'
          ></button>
        </span>
      </p>
      <p></p>
      <h3>₹ {expense.amount}</h3>
    </li>
  );
};

export default ExpenseItem;
