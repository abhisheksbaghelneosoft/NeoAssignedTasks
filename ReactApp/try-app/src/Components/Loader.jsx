import {InfinitySpin} from  'react-loader-spinner';

const LoaderComp = () => {
 
    return (
        <div style={{opacity:"0.8",minHeight:"100vh",display:"flex", justifyContent:"center",alignItems:"center"}}>
        <InfinitySpin
        color='#00ccaa'/>
        </div>
    );
}
export default LoaderComp;