// export default function Footer() {
//   return (
//     <div>
//       &copy; 2024 all rights reserved by{' '}
//       <a href='https://vinod.co'>Learn with Vinod</a>
//     </div>
//   );
// }

const Footer = () => {
  const fromYear = 2007;
  const toYear = new Date().getFullYear();
  const websiteUrl = 'https://vinod.co';
  const websiteTitle = 'Learn with Vinod';

  return (
    <div className='container text-center'>
      &copy; {fromYear}-{toYear} all rights reserved by{' '}
      <a href={websiteUrl}>{websiteTitle}</a>
    </div>
  );
};

export default Footer;
