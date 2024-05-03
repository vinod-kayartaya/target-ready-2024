import Header from './components/Header';
import Footer from './components/Footer';
import { Outlet } from 'react-router-dom';

const Layout = () => {
  

  return (
    <>
      <Header />
      <div style={{ minHeight: '650px' }} className='container'>
        <Outlet />
      </div>
      <Footer />
    </>
  );
};

export default Layout;
