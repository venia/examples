import {forwardRef} from "react";

const MyVideoPlayer = forwardRef(function MyVideoPlayer(
    {src, type, width},
    ref
){
    return(
        <video width={width} ref={ref}>
            <source src={src} type={type}/>
        </video>
    );
})

export default MyVideoPlayer;