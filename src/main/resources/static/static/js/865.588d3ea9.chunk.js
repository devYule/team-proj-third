"use strict";(self.webpackChunkelectro_rent=self.webpackChunkelectro_rent||[]).push([[865],{7902:(e,o,t)=>{t.d(o,{T8:()=>u,XQ:()=>i,hP:()=>l});var a=t(5294),n=t(3014);const c="beae94b18549648a1e9a98b4e0d945b2",s="http://localhost:3000/login/kakao",r=new URLSearchParams({client_id:c,redirect_uri:s,response_type:"code"}),i=()=>"".concat("https://kauth.kakao.com/oauth/authorize","?").concat(r.toString()),l=async e=>{const o={grant_type:"authorization_code",client_id:c,redirect_uri:s,code:e};return(await a.Z.post("https://kauth.kakao.com/oauth/token",o,{headers:{"Content-Type":"application/x-www-form-urlencoded;charset=utf-8"}})).data.access_token},u=async e=>{console.log("\ubc31\uc5d4\ub4dc\uc5d0 \ud68c\uc6d0 \ub4f1\ub85d\uc744 \uc704\ud55c \uc561\uc138\uc2a4 \ud1a0\ud070 \uc804\ub2ec ",e);return(await a.Z.get("".concat(n.L,"/api/user/kakao?accessToken=").concat(e))).data}},724:(e,o,t)=>{t.d(o,{Z:()=>r});var a=t(4420),n=t(7689),c=t(8089),s=t(184);const r=()=>{const e=(0,n.s0)(),o=(0,a.I0)();return{loginState:(0,a.v9)((e=>e.loginSlice)),isLogin:"true"===sessionStorage.getItem("isLogin"),doLogin:async e=>{let{loginParam:t,successFn:a,failFn:n,errorFn:s}=e;return(await o((0,c.ft)({loginParam:t,successFn:a,failFn:n,errorFn:s}))).payload},doLogout:()=>{o((0,c.kS)())},moveToPath:o=>{e({pathname:o},{replace:!0})},moveToLogin:()=>(0,s.jsx)(n.Fg,{replace:!0,to:"/member/login"}),userAuth:sessionStorage.getItem("userAuth")}}},2865:(e,o,t)=>{t.r(o),t.d(o,{default:()=>u});var a=t(2791),n=t(1087),c=t(7902),s=t(4420),r=t(8089),i=t(724),l=t(184);const u=()=>{const[e,o]=(0,n.lr)(),t=e.get("code"),u=(0,s.I0)(),{moveToPath:h}=(0,i.Z)();return(0,a.useEffect)((()=>{(0,c.hP)(t).then((e=>{console.log("access Token",e),(0,c.T8)(e).then((e=>{console.log("-------------------"),console.log(e),u((0,r.x4)(e)),e&&!e.social?h("/login"):h("/join/step_1")}))}))}),[t]),(0,l.jsxs)("div",{children:[(0,l.jsx)("h1",{children:"\uce74\uce74\uc624 \ub9ac\ub2e4\uc774\ub809\ud2b8 \ud398\uc774\uc9c0"}),(0,l.jsx)("div",{children:t})]})}}}]);
//# sourceMappingURL=865.588d3ea9.chunk.js.map