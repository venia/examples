import {forwardRef, useRef, useImperativeHandle} from "react";
import CommentList from "./CommentList";
import AddComment from "./AddComment";

const Post = forwardRef(function Post(props, ref) {
    const commentRef = useRef(null);
    const addCommentRef = useRef(null);

    useImperativeHandle(
        ref,
        () => {
            return {
                scrollAndFocusAddComment() {
                    commentRef.current.scrollToBottom();
                    addCommentRef.current.focus();
                }
            }
        },
        []
    )

    return (
        <>
            <article>
                <p>Welcome to my blog!</p>
            </article>

            <CommentList ref={commentRef} />
            <AddComment ref={addCommentRef} />
        </>
    );
})

export default Post;