const CheckComponent = (props) => {
    return (
        <svg className={`checked ${props.purpose}`} xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24"
             fill="none">
            <path fillRule="evenodd" clipRule="evenodd"
                  d="M12 1.25C6.063 1.25 1.25 6.063 1.25 12C1.25 17.937 6.063 22.75 12 22.75C17.937 22.75 22.75 17.937 22.75 12C22.75 6.063 17.937 1.25 12 1.25ZM7.53 11.97C7.38783 11.8375 7.19978 11.7654 7.00548 11.7688C6.81118 11.7723 6.62579 11.851 6.48838 11.9884C6.35097 12.1258 6.27225 12.3112 6.26883 12.5055C6.2654 12.6998 6.33752 12.8878 6.47 13.03L9.47 16.03C9.61063 16.1705 9.80125 16.2493 10 16.2493C10.1988 16.2493 10.3894 16.1705 10.53 16.03L17.53 9.03C17.6625 8.88783 17.7346 8.69978 17.7312 8.50548C17.7277 8.31118 17.649 8.12579 17.5116 7.98838C17.3742 7.85097 17.1888 7.77225 16.9945 7.76883C16.8002 7.7654 16.6122 7.83752 16.47 7.97L10 14.44L7.53 11.97Z"
                  fill="#F24E1E"/>
        </svg>
    );
}

export default CheckComponent