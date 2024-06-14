import {useRef} from 'react';
import Post from "./Post";

export default function Page() {
    const postRef = useRef(null);

    function handleClick() {
        postRef.current.scrollAndFocusAddComment();
    }

    return(
        <>
            <button onClick={handleClick}>
                Write a comment
            </button>
            <Post ref={postRef} />
        </>
    );
}