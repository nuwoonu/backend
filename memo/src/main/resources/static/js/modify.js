//삭제버튼 클릭시
//submit 기능 중지
document.querySelector(".btn-outline-danger").addEventListener("click", (e) => {
  //   e.preventDefault;
  const form = document.querySelector("#modify-form");
  //   e.target.action = "/memo/remove";
  form.action = "/memo/remove";
  //   e.target.submit();
  form.submit();
});
//form.action = "가야할곳"
