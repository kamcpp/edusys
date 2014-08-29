--
-- PostgreSQL database dump
--

SET statement_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;

--
-- Name: audit; Type: SCHEMA; Schema: -; Owner: edusysuser
--

CREATE SCHEMA audit;


ALTER SCHEMA audit OWNER TO edusysuser;

--
-- Name: cms; Type: SCHEMA; Schema: -; Owner: edusysuser
--

CREATE SCHEMA cms;


ALTER SCHEMA cms OWNER TO edusysuser;

--
-- Name: education; Type: SCHEMA; Schema: -; Owner: edusysuser
--

CREATE SCHEMA education;


ALTER SCHEMA education OWNER TO edusysuser;

--
-- Name: membership; Type: SCHEMA; Schema: -; Owner: edusysuser
--

CREATE SCHEMA membership;


ALTER SCHEMA membership OWNER TO edusysuser;

--
-- Name: messaging; Type: SCHEMA; Schema: -; Owner: edusysuser
--

CREATE SCHEMA messaging;


ALTER SCHEMA messaging OWNER TO edusysuser;

--
-- Name: official; Type: SCHEMA; Schema: -; Owner: edusysuser
--

CREATE SCHEMA official;


ALTER SCHEMA official OWNER TO edusysuser;

--
-- Name: personnel; Type: SCHEMA; Schema: -; Owner: edusysuser
--

CREATE SCHEMA personnel;


ALTER SCHEMA personnel OWNER TO edusysuser;

--
-- Name: phonebook; Type: SCHEMA; Schema: -; Owner: edusysuser
--

CREATE SCHEMA phonebook;


ALTER SCHEMA phonebook OWNER TO edusysuser;

--
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET search_path = audit, pg_catalog;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- Name: audit_log; Type: TABLE; Schema: audit; Owner: edusysuser; Tablespace: 
--

CREATE TABLE audit_log (
    id bigint NOT NULL,
    application character varying(5120),
    client_computer_name character varying(5120),
    client_date_time bigint,
    client_ip_address character varying(5120),
    client_mac_address character varying(5120),
    description character varying(20480),
    details character varying(20480),
    local_address character varying(5120),
    log_date_time bigint NOT NULL,
    operation character varying(5120),
    person_id bigint,
    remote_address character varying(5120),
    service character varying(5120),
    service_version character varying(5120),
    token_id bigint,
    username character varying(5120)
);


ALTER TABLE audit.audit_log OWNER TO edusysuser;

SET search_path = cms, pg_catalog;

--
-- Name: class; Type: TABLE; Schema: cms; Owner: edusysuser; Tablespace: 
--

CREATE TABLE class (
    id bigint NOT NULL,
    name character varying(5120) NOT NULL,
    cms_group_id bigint NOT NULL
);


ALTER TABLE cms.class OWNER TO edusysuser;

--
-- Name: department; Type: TABLE; Schema: cms; Owner: edusysuser; Tablespace: 
--

CREATE TABLE department (
    id bigint NOT NULL,
    name character varying(5120) NOT NULL
);


ALTER TABLE cms.department OWNER TO edusysuser;

--
-- Name: general_reservation; Type: TABLE; Schema: cms; Owner: edusysuser; Tablespace: 
--

CREATE TABLE general_reservation (
    id bigint NOT NULL,
    calculated_date bigint,
    called boolean NOT NULL,
    cancelled boolean,
    date character varying(5120) NOT NULL,
    description character varying(5120),
    email character varying(5120) NOT NULL,
    followed boolean,
    has_registered boolean,
    name character varying(5120) NOT NULL,
    not_answered boolean,
    phone character varying(5120) NOT NULL,
    seen boolean NOT NULL,
    sms_sent boolean NOT NULL,
    source character varying(20480),
    text character varying(5120) NOT NULL,
    will_inform_us boolean,
    will_register boolean,
    will_registered_with_conditions boolean,
    cms_class_id bigint NOT NULL
);


ALTER TABLE cms.general_reservation OWNER TO edusysuser;

--
-- Name: group; Type: TABLE; Schema: cms; Owner: edusysuser; Tablespace: 
--

CREATE TABLE "group" (
    id bigint NOT NULL,
    name character varying(5120) NOT NULL,
    cms_department_id bigint NOT NULL
);


ALTER TABLE cms."group" OWNER TO edusysuser;

--
-- Name: reservation; Type: TABLE; Schema: cms; Owner: edusysuser; Tablespace: 
--

CREATE TABLE reservation (
    id bigint NOT NULL,
    calculated_date bigint,
    date character varying(5120) NOT NULL,
    email character varying(5120) NOT NULL,
    name character varying(5120) NOT NULL,
    phone character varying(5120) NOT NULL,
    text character varying(5120) NOT NULL,
    "time" character varying(5120) NOT NULL,
    cms_department_id bigint NOT NULL,
    cms_reservation_plan_id bigint NOT NULL
);


ALTER TABLE cms.reservation OWNER TO edusysuser;

--
-- Name: reservation_plan; Type: TABLE; Schema: cms; Owner: edusysuser; Tablespace: 
--

CREATE TABLE reservation_plan (
    id bigint NOT NULL,
    name character varying(5120) NOT NULL
);


ALTER TABLE cms.reservation_plan OWNER TO edusysuser;

SET search_path = education, pg_catalog;

--
-- Name: course; Type: TABLE; Schema: education; Owner: edusysuser; Tablespace: 
--

CREATE TABLE course (
    id bigint NOT NULL,
    english_name character varying(5120),
    persian_name character varying(5120) NOT NULL,
    group_id bigint NOT NULL
);


ALTER TABLE education.course OWNER TO edusysuser;

--
-- Name: course_class; Type: TABLE; Schema: education; Owner: edusysuser; Tablespace: 
--

CREATE TABLE course_class (
    id bigint NOT NULL
);


ALTER TABLE education.course_class OWNER TO edusysuser;

--
-- Name: course_class_id_seq; Type: SEQUENCE; Schema: education; Owner: edusysuser
--

CREATE SEQUENCE course_class_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE education.course_class_id_seq OWNER TO edusysuser;

--
-- Name: course_class_id_seq; Type: SEQUENCE OWNED BY; Schema: education; Owner: edusysuser
--

ALTER SEQUENCE course_class_id_seq OWNED BY course_class.id;


--
-- Name: course_id_seq; Type: SEQUENCE; Schema: education; Owner: edusysuser
--

CREATE SEQUENCE course_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE education.course_id_seq OWNER TO edusysuser;

--
-- Name: course_id_seq; Type: SEQUENCE OWNED BY; Schema: education; Owner: edusysuser
--

ALTER SEQUENCE course_id_seq OWNED BY course.id;


--
-- Name: course_tags; Type: TABLE; Schema: education; Owner: edusysuser; Tablespace: 
--

CREATE TABLE course_tags (
    course_id bigint NOT NULL,
    tag_id bigint NOT NULL
);


ALTER TABLE education.course_tags OWNER TO edusysuser;

--
-- Name: department; Type: TABLE; Schema: education; Owner: edusysuser; Tablespace: 
--

CREATE TABLE department (
    id bigint NOT NULL,
    color character varying(5120) NOT NULL,
    english_name character varying(5120) NOT NULL,
    htmlcontent character varying(20480),
    persian_name character varying(5120) NOT NULL,
    seo_description character varying(20480),
    seo_keywords character varying(20480),
    show_order integer NOT NULL,
    institute_id bigint NOT NULL
);


ALTER TABLE education.department OWNER TO edusysuser;

--
-- Name: department_id_seq; Type: SEQUENCE; Schema: education; Owner: edusysuser
--

CREATE SEQUENCE department_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE education.department_id_seq OWNER TO edusysuser;

--
-- Name: department_id_seq; Type: SEQUENCE OWNED BY; Schema: education; Owner: edusysuser
--

ALTER SEQUENCE department_id_seq OWNED BY department.id;


--
-- Name: group; Type: TABLE; Schema: education; Owner: edusysuser; Tablespace: 
--

CREATE TABLE "group" (
    id bigint NOT NULL,
    english_name character varying(5120) NOT NULL,
    htmlcontent character varying(20480),
    persian_name character varying(5120) NOT NULL,
    seo_description character varying(20480),
    seo_keywords character varying(20480),
    show_order integer NOT NULL,
    department_id bigint NOT NULL
);


ALTER TABLE education."group" OWNER TO edusysuser;

--
-- Name: group_id_seq; Type: SEQUENCE; Schema: education; Owner: edusysuser
--

CREATE SEQUENCE group_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE education.group_id_seq OWNER TO edusysuser;

--
-- Name: group_id_seq; Type: SEQUENCE OWNED BY; Schema: education; Owner: edusysuser
--

ALTER SEQUENCE group_id_seq OWNED BY "group".id;


--
-- Name: institute; Type: TABLE; Schema: education; Owner: edusysuser; Tablespace: 
--

CREATE TABLE institute (
    id bigint NOT NULL,
    email1 character varying(5120),
    email2 character varying(5120),
    english_name character varying(5120) NOT NULL,
    fax_number character varying(5120),
    persian_name character varying(5120) NOT NULL,
    phone1 character varying(5120),
    phone2 character varying(5120),
    web_url1 character varying(5120),
    web_url2 character varying(5120)
);


ALTER TABLE education.institute OWNER TO edusysuser;

--
-- Name: institute_id_seq; Type: SEQUENCE; Schema: education; Owner: edusysuser
--

CREATE SEQUENCE institute_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE education.institute_id_seq OWNER TO edusysuser;

--
-- Name: institute_id_seq; Type: SEQUENCE OWNED BY; Schema: education; Owner: edusysuser
--

ALTER SEQUENCE institute_id_seq OWNED BY institute.id;


--
-- Name: student; Type: TABLE; Schema: education; Owner: edusysuser; Tablespace: 
--

CREATE TABLE student (
    person_id bigint NOT NULL,
    student_number character varying(5120) NOT NULL
);


ALTER TABLE education.student OWNER TO edusysuser;

--
-- Name: tag; Type: TABLE; Schema: education; Owner: edusysuser; Tablespace: 
--

CREATE TABLE tag (
    id bigint NOT NULL,
    english_name character varying(5120) NOT NULL,
    persian_name character varying(5120) NOT NULL,
    parent_tag_id bigint
);


ALTER TABLE education.tag OWNER TO edusysuser;

--
-- Name: tag_id_seq; Type: SEQUENCE; Schema: education; Owner: edusysuser
--

CREATE SEQUENCE tag_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE education.tag_id_seq OWNER TO edusysuser;

--
-- Name: tag_id_seq; Type: SEQUENCE OWNED BY; Schema: education; Owner: edusysuser
--

ALTER SEQUENCE tag_id_seq OWNED BY tag.id;


--
-- Name: teacher; Type: TABLE; Schema: education; Owner: edusysuser; Tablespace: 
--

CREATE TABLE teacher (
    person_id bigint NOT NULL
);


ALTER TABLE education.teacher OWNER TO edusysuser;

--
-- Name: term; Type: TABLE; Schema: education; Owner: edusysuser; Tablespace: 
--

CREATE TABLE term (
    id bigint NOT NULL,
    english_name character varying(5120) NOT NULL,
    persian_name character varying(5120) NOT NULL,
    institute_id bigint NOT NULL
);


ALTER TABLE education.term OWNER TO edusysuser;

--
-- Name: term_id_seq; Type: SEQUENCE; Schema: education; Owner: edusysuser
--

CREATE SEQUENCE term_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE education.term_id_seq OWNER TO edusysuser;

--
-- Name: term_id_seq; Type: SEQUENCE OWNED BY; Schema: education; Owner: edusysuser
--

ALTER SEQUENCE term_id_seq OWNED BY term.id;


SET search_path = membership, pg_catalog;

--
-- Name: role; Type: TABLE; Schema: membership; Owner: edusysuser; Tablespace: 
--

CREATE TABLE role (
    id bigint NOT NULL,
    name character varying(5120) NOT NULL
);


ALTER TABLE membership.role OWNER TO edusysuser;

--
-- Name: role_id_seq; Type: SEQUENCE; Schema: membership; Owner: edusysuser
--

CREATE SEQUENCE role_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE membership.role_id_seq OWNER TO edusysuser;

--
-- Name: role_id_seq; Type: SEQUENCE OWNED BY; Schema: membership; Owner: edusysuser
--

ALTER SEQUENCE role_id_seq OWNED BY role.id;


--
-- Name: token; Type: TABLE; Schema: membership; Owner: edusysuser; Tablespace: 
--

CREATE TABLE token (
    id bigint NOT NULL,
    active boolean NOT NULL,
    deactivity_maximum_duration_in_minutes bigint NOT NULL,
    description character varying(20480),
    expire_date bigint NOT NULL,
    last_access_date bigint NOT NULL,
    submit_date bigint NOT NULL,
    value character varying(5120) NOT NULL,
    user_id bigint NOT NULL
);


ALTER TABLE membership.token OWNER TO edusysuser;

--
-- Name: token_id_seq; Type: SEQUENCE; Schema: membership; Owner: edusysuser
--

CREATE SEQUENCE token_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE membership.token_id_seq OWNER TO edusysuser;

--
-- Name: token_id_seq; Type: SEQUENCE OWNED BY; Schema: membership; Owner: edusysuser
--

ALTER SEQUENCE token_id_seq OWNED BY token.id;


--
-- Name: user; Type: TABLE; Schema: membership; Owner: edusysuser; Tablespace: 
--

CREATE TABLE "user" (
    person_id bigint NOT NULL,
    accountemail character varying(5120) NOT NULL,
    active boolean NOT NULL,
    hashed_password character varying(5120) NOT NULL,
    username character varying(5120) NOT NULL
);


ALTER TABLE membership."user" OWNER TO edusysuser;

--
-- Name: user_role; Type: TABLE; Schema: membership; Owner: edusysuser; Tablespace: 
--

CREATE TABLE user_role (
    user_id bigint NOT NULL,
    role_id bigint NOT NULL
);


ALTER TABLE membership.user_role OWNER TO edusysuser;

SET search_path = messaging, pg_catalog;

--
-- Name: todo_item; Type: TABLE; Schema: messaging; Owner: edusysuser; Tablespace: 
--

CREATE TABLE todo_item (
    id bigint NOT NULL,
    color character varying(255),
    deadline_date bigint,
    description character varying(20480),
    done boolean NOT NULL,
    priority integer NOT NULL,
    response character varying(20480),
    subject character varying(5120) NOT NULL,
    submit_date bigint NOT NULL,
    owner_person_id bigint NOT NULL,
    receiver_person_id bigint NOT NULL
);


ALTER TABLE messaging.todo_item OWNER TO edusysuser;

--
-- Name: todo_item_id_seq; Type: SEQUENCE; Schema: messaging; Owner: edusysuser
--

CREATE SEQUENCE todo_item_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE messaging.todo_item_id_seq OWNER TO edusysuser;

--
-- Name: todo_item_id_seq; Type: SEQUENCE OWNED BY; Schema: messaging; Owner: edusysuser
--

ALTER SEQUENCE todo_item_id_seq OWNED BY todo_item.id;


SET search_path = official, pg_catalog;

--
-- Name: employee; Type: TABLE; Schema: official; Owner: edusysuser; Tablespace: 
--

CREATE TABLE employee (
    person_id bigint NOT NULL,
    employee_number character varying(5120) NOT NULL
);


ALTER TABLE official.employee OWNER TO edusysuser;

SET search_path = personnel, pg_catalog;

--
-- Name: person; Type: TABLE; Schema: personnel; Owner: edusysuser; Tablespace: 
--

CREATE TABLE person (
    id bigint NOT NULL,
    address1 character varying(5120),
    address2 character varying(5120),
    birth_date bigint,
    description character varying(20480),
    email1 character varying(5120),
    email2 character varying(5120),
    english_family character varying(5120),
    english_name character varying(5120),
    father_name character varying(5120),
    gender integer NOT NULL,
    national_code character varying(5120),
    persian_family character varying(5120) NOT NULL,
    persian_name character varying(5120) NOT NULL,
    phone1 character varying(5120),
    phone2 character varying(5120),
    phone3 character varying(5120),
    sh_location character varying(5120),
    sh_sh character varying(5120),
    web_url1 character varying(5120),
    web_url2 character varying(5120)
);


ALTER TABLE personnel.person OWNER TO edusysuser;

--
-- Name: person_id_seq; Type: SEQUENCE; Schema: personnel; Owner: edusysuser
--

CREATE SEQUENCE person_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE personnel.person_id_seq OWNER TO edusysuser;

--
-- Name: person_id_seq; Type: SEQUENCE OWNED BY; Schema: personnel; Owner: edusysuser
--

ALTER SEQUENCE person_id_seq OWNED BY person.id;


SET search_path = phonebook, pg_catalog;

--
-- Name: follow_up; Type: TABLE; Schema: phonebook; Owner: edusysuser; Tablespace: 
--

CREATE TABLE follow_up (
    id bigint NOT NULL,
    answered boolean NOT NULL,
    color character varying(255) NOT NULL,
    description character varying(20480),
    desired_courses character varying(20480),
    desired_times character varying(20480),
    phone_number_is_not_active boolean NOT NULL,
    question character varying(20480),
    status character varying(255) NOT NULL,
    submit_date bigint NOT NULL,
    owner_id bigint NOT NULL,
    phone_entry_id bigint NOT NULL
);


ALTER TABLE phonebook.follow_up OWNER TO edusysuser;

--
-- Name: follow_up_id_seq; Type: SEQUENCE; Schema: phonebook; Owner: edusysuser
--

CREATE SEQUENCE follow_up_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE phonebook.follow_up_id_seq OWNER TO edusysuser;

--
-- Name: follow_up_id_seq; Type: SEQUENCE OWNED BY; Schema: phonebook; Owner: edusysuser
--

ALTER SEQUENCE follow_up_id_seq OWNED BY follow_up.id;


--
-- Name: phone_entry; Type: TABLE; Schema: phonebook; Owner: edusysuser; Tablespace: 
--

CREATE TABLE phone_entry (
    id bigint NOT NULL,
    color character varying(255),
    description character varying(20480) NOT NULL,
    method_de_connaissance integer,
    name character varying(5120) NOT NULL,
    number character varying(5120) NOT NULL,
    private_class boolean,
    registered boolean,
    response character varying(20480),
    seen boolean NOT NULL,
    should_be_followed boolean,
    submit_date bigint,
    department_id bigint NOT NULL,
    employee_id bigint NOT NULL
);


ALTER TABLE phonebook.phone_entry OWNER TO edusysuser;

--
-- Name: phone_entry_id_seq; Type: SEQUENCE; Schema: phonebook; Owner: edusysuser
--

CREATE SEQUENCE phone_entry_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE phonebook.phone_entry_id_seq OWNER TO edusysuser;

--
-- Name: phone_entry_id_seq; Type: SEQUENCE OWNED BY; Schema: phonebook; Owner: edusysuser
--

ALTER SEQUENCE phone_entry_id_seq OWNED BY phone_entry.id;


SET search_path = public, pg_catalog;

--
-- Name: followup; Type: TABLE; Schema: public; Owner: edusysuser; Tablespace: 
--

CREATE TABLE followup (
    id bigint NOT NULL,
    answered boolean NOT NULL,
    color character varying(255) NOT NULL,
    description character varying(20480),
    desired_courses character varying(20480),
    desired_times character varying(20480),
    phone_number_is_not_active boolean NOT NULL,
    question character varying(20480),
    status character varying(255) NOT NULL,
    submit_date bigint NOT NULL,
    owner_id bigint NOT NULL,
    phone_entry_id bigint NOT NULL
);


ALTER TABLE public.followup OWNER TO edusysuser;

--
-- Name: followup_id_seq; Type: SEQUENCE; Schema: public; Owner: edusysuser
--

CREATE SEQUENCE followup_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.followup_id_seq OWNER TO edusysuser;

--
-- Name: followup_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: edusysuser
--

ALTER SEQUENCE followup_id_seq OWNED BY followup.id;


--
-- Name: hibernate_sequence; Type: SEQUENCE; Schema: public; Owner: edusysuser
--

CREATE SEQUENCE hibernate_sequence
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.hibernate_sequence OWNER TO edusysuser;

--
-- Name: phoneentry; Type: TABLE; Schema: public; Owner: edusysuser; Tablespace: 
--

CREATE TABLE phoneentry (
    id bigint NOT NULL,
    color character varying(255) NOT NULL,
    description character varying(20480) NOT NULL,
    method_de_connaissance integer,
    name character varying(5120) NOT NULL,
    number character varying(5120) NOT NULL,
    seen boolean NOT NULL,
    submit_date bigint NOT NULL,
    department_id bigint NOT NULL,
    employee_id bigint NOT NULL
);


ALTER TABLE public.phoneentry OWNER TO edusysuser;

--
-- Name: phoneentry_id_seq; Type: SEQUENCE; Schema: public; Owner: edusysuser
--

CREATE SEQUENCE phoneentry_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.phoneentry_id_seq OWNER TO edusysuser;

--
-- Name: phoneentry_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: edusysuser
--

ALTER SEQUENCE phoneentry_id_seq OWNED BY phoneentry.id;


SET search_path = education, pg_catalog;

--
-- Name: id; Type: DEFAULT; Schema: education; Owner: edusysuser
--

ALTER TABLE ONLY course ALTER COLUMN id SET DEFAULT nextval('course_id_seq'::regclass);


--
-- Name: id; Type: DEFAULT; Schema: education; Owner: edusysuser
--

ALTER TABLE ONLY course_class ALTER COLUMN id SET DEFAULT nextval('course_class_id_seq'::regclass);


--
-- Name: id; Type: DEFAULT; Schema: education; Owner: edusysuser
--

ALTER TABLE ONLY department ALTER COLUMN id SET DEFAULT nextval('department_id_seq'::regclass);


--
-- Name: id; Type: DEFAULT; Schema: education; Owner: edusysuser
--

ALTER TABLE ONLY "group" ALTER COLUMN id SET DEFAULT nextval('group_id_seq'::regclass);


--
-- Name: id; Type: DEFAULT; Schema: education; Owner: edusysuser
--

ALTER TABLE ONLY institute ALTER COLUMN id SET DEFAULT nextval('institute_id_seq'::regclass);


--
-- Name: id; Type: DEFAULT; Schema: education; Owner: edusysuser
--

ALTER TABLE ONLY tag ALTER COLUMN id SET DEFAULT nextval('tag_id_seq'::regclass);


--
-- Name: id; Type: DEFAULT; Schema: education; Owner: edusysuser
--

ALTER TABLE ONLY term ALTER COLUMN id SET DEFAULT nextval('term_id_seq'::regclass);


SET search_path = membership, pg_catalog;

--
-- Name: id; Type: DEFAULT; Schema: membership; Owner: edusysuser
--

ALTER TABLE ONLY role ALTER COLUMN id SET DEFAULT nextval('role_id_seq'::regclass);


--
-- Name: id; Type: DEFAULT; Schema: membership; Owner: edusysuser
--

ALTER TABLE ONLY token ALTER COLUMN id SET DEFAULT nextval('token_id_seq'::regclass);


SET search_path = messaging, pg_catalog;

--
-- Name: id; Type: DEFAULT; Schema: messaging; Owner: edusysuser
--

ALTER TABLE ONLY todo_item ALTER COLUMN id SET DEFAULT nextval('todo_item_id_seq'::regclass);


SET search_path = personnel, pg_catalog;

--
-- Name: id; Type: DEFAULT; Schema: personnel; Owner: edusysuser
--

ALTER TABLE ONLY person ALTER COLUMN id SET DEFAULT nextval('person_id_seq'::regclass);


SET search_path = phonebook, pg_catalog;

--
-- Name: id; Type: DEFAULT; Schema: phonebook; Owner: edusysuser
--

ALTER TABLE ONLY follow_up ALTER COLUMN id SET DEFAULT nextval('follow_up_id_seq'::regclass);


--
-- Name: id; Type: DEFAULT; Schema: phonebook; Owner: edusysuser
--

ALTER TABLE ONLY phone_entry ALTER COLUMN id SET DEFAULT nextval('phone_entry_id_seq'::regclass);


SET search_path = public, pg_catalog;

--
-- Name: id; Type: DEFAULT; Schema: public; Owner: edusysuser
--

ALTER TABLE ONLY followup ALTER COLUMN id SET DEFAULT nextval('followup_id_seq'::regclass);


--
-- Name: id; Type: DEFAULT; Schema: public; Owner: edusysuser
--

ALTER TABLE ONLY phoneentry ALTER COLUMN id SET DEFAULT nextval('phoneentry_id_seq'::regclass);


SET search_path = audit, pg_catalog;

--
-- Name: audit_log_pkey; Type: CONSTRAINT; Schema: audit; Owner: edusysuser; Tablespace: 
--

ALTER TABLE ONLY audit_log
    ADD CONSTRAINT audit_log_pkey PRIMARY KEY (id);


SET search_path = cms, pg_catalog;

--
-- Name: class_pkey; Type: CONSTRAINT; Schema: cms; Owner: edusysuser; Tablespace: 
--

ALTER TABLE ONLY class
    ADD CONSTRAINT class_pkey PRIMARY KEY (id);


--
-- Name: department_pkey; Type: CONSTRAINT; Schema: cms; Owner: edusysuser; Tablespace: 
--

ALTER TABLE ONLY department
    ADD CONSTRAINT department_pkey PRIMARY KEY (id);


--
-- Name: general_reservation_pkey; Type: CONSTRAINT; Schema: cms; Owner: edusysuser; Tablespace: 
--

ALTER TABLE ONLY general_reservation
    ADD CONSTRAINT general_reservation_pkey PRIMARY KEY (id);


--
-- Name: group_pkey; Type: CONSTRAINT; Schema: cms; Owner: edusysuser; Tablespace: 
--

ALTER TABLE ONLY "group"
    ADD CONSTRAINT group_pkey PRIMARY KEY (id);


--
-- Name: reservation_pkey; Type: CONSTRAINT; Schema: cms; Owner: edusysuser; Tablespace: 
--

ALTER TABLE ONLY reservation
    ADD CONSTRAINT reservation_pkey PRIMARY KEY (id);


--
-- Name: reservation_plan_pkey; Type: CONSTRAINT; Schema: cms; Owner: edusysuser; Tablespace: 
--

ALTER TABLE ONLY reservation_plan
    ADD CONSTRAINT reservation_plan_pkey PRIMARY KEY (id);


SET search_path = education, pg_catalog;

--
-- Name: course_class_pkey; Type: CONSTRAINT; Schema: education; Owner: edusysuser; Tablespace: 
--

ALTER TABLE ONLY course_class
    ADD CONSTRAINT course_class_pkey PRIMARY KEY (id);


--
-- Name: course_pkey; Type: CONSTRAINT; Schema: education; Owner: edusysuser; Tablespace: 
--

ALTER TABLE ONLY course
    ADD CONSTRAINT course_pkey PRIMARY KEY (id);


--
-- Name: course_tags_pkey; Type: CONSTRAINT; Schema: education; Owner: edusysuser; Tablespace: 
--

ALTER TABLE ONLY course_tags
    ADD CONSTRAINT course_tags_pkey PRIMARY KEY (course_id, tag_id);


--
-- Name: department_pkey; Type: CONSTRAINT; Schema: education; Owner: edusysuser; Tablespace: 
--

ALTER TABLE ONLY department
    ADD CONSTRAINT department_pkey PRIMARY KEY (id);


--
-- Name: group_pkey; Type: CONSTRAINT; Schema: education; Owner: edusysuser; Tablespace: 
--

ALTER TABLE ONLY "group"
    ADD CONSTRAINT group_pkey PRIMARY KEY (id);


--
-- Name: institute_pkey; Type: CONSTRAINT; Schema: education; Owner: edusysuser; Tablespace: 
--

ALTER TABLE ONLY institute
    ADD CONSTRAINT institute_pkey PRIMARY KEY (id);


--
-- Name: student_pkey; Type: CONSTRAINT; Schema: education; Owner: edusysuser; Tablespace: 
--

ALTER TABLE ONLY student
    ADD CONSTRAINT student_pkey PRIMARY KEY (person_id);


--
-- Name: tag_pkey; Type: CONSTRAINT; Schema: education; Owner: edusysuser; Tablespace: 
--

ALTER TABLE ONLY tag
    ADD CONSTRAINT tag_pkey PRIMARY KEY (id);


--
-- Name: teacher_pkey; Type: CONSTRAINT; Schema: education; Owner: edusysuser; Tablespace: 
--

ALTER TABLE ONLY teacher
    ADD CONSTRAINT teacher_pkey PRIMARY KEY (person_id);


--
-- Name: term_pkey; Type: CONSTRAINT; Schema: education; Owner: edusysuser; Tablespace: 
--

ALTER TABLE ONLY term
    ADD CONSTRAINT term_pkey PRIMARY KEY (id);


SET search_path = membership, pg_catalog;

--
-- Name: role_pkey; Type: CONSTRAINT; Schema: membership; Owner: edusysuser; Tablespace: 
--

ALTER TABLE ONLY role
    ADD CONSTRAINT role_pkey PRIMARY KEY (id);


--
-- Name: token_pkey; Type: CONSTRAINT; Schema: membership; Owner: edusysuser; Tablespace: 
--

ALTER TABLE ONLY token
    ADD CONSTRAINT token_pkey PRIMARY KEY (id);


--
-- Name: user_accountemail_key; Type: CONSTRAINT; Schema: membership; Owner: edusysuser; Tablespace: 
--

ALTER TABLE ONLY "user"
    ADD CONSTRAINT user_accountemail_key UNIQUE (accountemail);


--
-- Name: user_pkey; Type: CONSTRAINT; Schema: membership; Owner: edusysuser; Tablespace: 
--

ALTER TABLE ONLY "user"
    ADD CONSTRAINT user_pkey PRIMARY KEY (person_id);


--
-- Name: user_role_pkey; Type: CONSTRAINT; Schema: membership; Owner: edusysuser; Tablespace: 
--

ALTER TABLE ONLY user_role
    ADD CONSTRAINT user_role_pkey PRIMARY KEY (user_id, role_id);


--
-- Name: user_username_key; Type: CONSTRAINT; Schema: membership; Owner: edusysuser; Tablespace: 
--

ALTER TABLE ONLY "user"
    ADD CONSTRAINT user_username_key UNIQUE (username);


SET search_path = messaging, pg_catalog;

--
-- Name: todo_item_pkey; Type: CONSTRAINT; Schema: messaging; Owner: edusysuser; Tablespace: 
--

ALTER TABLE ONLY todo_item
    ADD CONSTRAINT todo_item_pkey PRIMARY KEY (id);


SET search_path = official, pg_catalog;

--
-- Name: employee_pkey; Type: CONSTRAINT; Schema: official; Owner: edusysuser; Tablespace: 
--

ALTER TABLE ONLY employee
    ADD CONSTRAINT employee_pkey PRIMARY KEY (person_id);


SET search_path = personnel, pg_catalog;

--
-- Name: person_pkey; Type: CONSTRAINT; Schema: personnel; Owner: edusysuser; Tablespace: 
--

ALTER TABLE ONLY person
    ADD CONSTRAINT person_pkey PRIMARY KEY (id);


SET search_path = phonebook, pg_catalog;

--
-- Name: follow_up_pkey; Type: CONSTRAINT; Schema: phonebook; Owner: edusysuser; Tablespace: 
--

ALTER TABLE ONLY follow_up
    ADD CONSTRAINT follow_up_pkey PRIMARY KEY (id);


--
-- Name: phone_entry_pkey; Type: CONSTRAINT; Schema: phonebook; Owner: edusysuser; Tablespace: 
--

ALTER TABLE ONLY phone_entry
    ADD CONSTRAINT phone_entry_pkey PRIMARY KEY (id);


SET search_path = public, pg_catalog;

--
-- Name: followup_pkey; Type: CONSTRAINT; Schema: public; Owner: edusysuser; Tablespace: 
--

ALTER TABLE ONLY followup
    ADD CONSTRAINT followup_pkey PRIMARY KEY (id);


--
-- Name: phoneentry_pkey; Type: CONSTRAINT; Schema: public; Owner: edusysuser; Tablespace: 
--

ALTER TABLE ONLY phoneentry
    ADD CONSTRAINT phoneentry_pkey PRIMARY KEY (id);


SET search_path = cms, pg_catalog;

--
-- Name: fk5a5a97878dcb0f5; Type: FK CONSTRAINT; Schema: cms; Owner: edusysuser
--

ALTER TABLE ONLY class
    ADD CONSTRAINT fk5a5a97878dcb0f5 FOREIGN KEY (cms_group_id) REFERENCES "group"(id);


--
-- Name: fk5e0f67f6c5f9dbf; Type: FK CONSTRAINT; Schema: cms; Owner: edusysuser
--

ALTER TABLE ONLY "group"
    ADD CONSTRAINT fk5e0f67f6c5f9dbf FOREIGN KEY (cms_department_id) REFERENCES department(id);


--
-- Name: fka2d543cc6c5f9dbf; Type: FK CONSTRAINT; Schema: cms; Owner: edusysuser
--

ALTER TABLE ONLY reservation
    ADD CONSTRAINT fka2d543cc6c5f9dbf FOREIGN KEY (cms_department_id) REFERENCES department(id);


--
-- Name: fka2d543ccb5528cc2; Type: FK CONSTRAINT; Schema: cms; Owner: edusysuser
--

ALTER TABLE ONLY reservation
    ADD CONSTRAINT fka2d543ccb5528cc2 FOREIGN KEY (cms_reservation_plan_id) REFERENCES reservation_plan(id);


--
-- Name: fkaa6c8ef583b8a255; Type: FK CONSTRAINT; Schema: cms; Owner: edusysuser
--

ALTER TABLE ONLY general_reservation
    ADD CONSTRAINT fkaa6c8ef583b8a255 FOREIGN KEY (cms_class_id) REFERENCES class(id);


SET search_path = education, pg_catalog;

--
-- Name: fk1bf9ad3795460; Type: FK CONSTRAINT; Schema: education; Owner: edusysuser
--

ALTER TABLE ONLY tag
    ADD CONSTRAINT fk1bf9ad3795460 FOREIGN KEY (parent_tag_id) REFERENCES tag(id);


--
-- Name: fk328e435241f6f48b; Type: FK CONSTRAINT; Schema: education; Owner: edusysuser
--

ALTER TABLE ONLY department
    ADD CONSTRAINT fk328e435241f6f48b FOREIGN KEY (institute_id) REFERENCES institute(id);


--
-- Name: fk36446c41f6f48b; Type: FK CONSTRAINT; Schema: education; Owner: edusysuser
--

ALTER TABLE ONLY term
    ADD CONSTRAINT fk36446c41f6f48b FOREIGN KEY (institute_id) REFERENCES institute(id);


--
-- Name: fk5e0f67f93e47fa9; Type: FK CONSTRAINT; Schema: education; Owner: edusysuser
--

ALTER TABLE ONLY "group"
    ADD CONSTRAINT fk5e0f67f93e47fa9 FOREIGN KEY (department_id) REFERENCES department(id);


--
-- Name: fk8ffe823bb3f22ad1; Type: FK CONSTRAINT; Schema: education; Owner: edusysuser
--

ALTER TABLE ONLY student
    ADD CONSTRAINT fk8ffe823bb3f22ad1 FOREIGN KEY (person_id) REFERENCES personnel.person(id);


--
-- Name: fkaa31cbe2b3f22ad1; Type: FK CONSTRAINT; Schema: education; Owner: edusysuser
--

ALTER TABLE ONLY teacher
    ADD CONSTRAINT fkaa31cbe2b3f22ad1 FOREIGN KEY (person_id) REFERENCES personnel.person(id);


--
-- Name: fkaf42e01b5018c4cb; Type: FK CONSTRAINT; Schema: education; Owner: edusysuser
--

ALTER TABLE ONLY course
    ADD CONSTRAINT fkaf42e01b5018c4cb FOREIGN KEY (group_id) REFERENCES "group"(id);


--
-- Name: fkfb0ce5bd5bc34e89; Type: FK CONSTRAINT; Schema: education; Owner: edusysuser
--

ALTER TABLE ONLY course_tags
    ADD CONSTRAINT fkfb0ce5bd5bc34e89 FOREIGN KEY (course_id) REFERENCES course(id);


--
-- Name: fkfb0ce5bd7825932b; Type: FK CONSTRAINT; Schema: education; Owner: edusysuser
--

ALTER TABLE ONLY course_tags
    ADD CONSTRAINT fkfb0ce5bd7825932b FOREIGN KEY (tag_id) REFERENCES tag(id);


SET search_path = membership, pg_catalog;

--
-- Name: fk143bf46a234bc669; Type: FK CONSTRAINT; Schema: membership; Owner: edusysuser
--

ALTER TABLE ONLY user_role
    ADD CONSTRAINT fk143bf46a234bc669 FOREIGN KEY (user_id) REFERENCES "user"(person_id);


--
-- Name: fk143bf46a7e210289; Type: FK CONSTRAINT; Schema: membership; Owner: edusysuser
--

ALTER TABLE ONLY user_role
    ADD CONSTRAINT fk143bf46a7e210289 FOREIGN KEY (role_id) REFERENCES role(id);


--
-- Name: fk36ebcbb3f22ad1; Type: FK CONSTRAINT; Schema: membership; Owner: edusysuser
--

ALTER TABLE ONLY "user"
    ADD CONSTRAINT fk36ebcbb3f22ad1 FOREIGN KEY (person_id) REFERENCES personnel.person(id);


--
-- Name: fk696b9f9234bc669; Type: FK CONSTRAINT; Schema: membership; Owner: edusysuser
--

ALTER TABLE ONLY token
    ADD CONSTRAINT fk696b9f9234bc669 FOREIGN KEY (user_id) REFERENCES "user"(person_id);


SET search_path = messaging, pg_catalog;

--
-- Name: fka66a076c22a99445; Type: FK CONSTRAINT; Schema: messaging; Owner: edusysuser
--

ALTER TABLE ONLY todo_item
    ADD CONSTRAINT fka66a076c22a99445 FOREIGN KEY (owner_person_id) REFERENCES personnel.person(id);


--
-- Name: fka66a076c5172b081; Type: FK CONSTRAINT; Schema: messaging; Owner: edusysuser
--

ALTER TABLE ONLY todo_item
    ADD CONSTRAINT fka66a076c5172b081 FOREIGN KEY (receiver_person_id) REFERENCES personnel.person(id);


SET search_path = official, pg_catalog;

--
-- Name: fk4722e6aeb3f22ad1; Type: FK CONSTRAINT; Schema: official; Owner: edusysuser
--

ALTER TABLE ONLY employee
    ADD CONSTRAINT fk4722e6aeb3f22ad1 FOREIGN KEY (person_id) REFERENCES personnel.person(id);


SET search_path = phonebook, pg_catalog;

--
-- Name: fk2da6cde91979e57d; Type: FK CONSTRAINT; Schema: phonebook; Owner: edusysuser
--

ALTER TABLE ONLY follow_up
    ADD CONSTRAINT fk2da6cde91979e57d FOREIGN KEY (phone_entry_id) REFERENCES phone_entry(id);


--
-- Name: fk2da6cde9d3e5b02f; Type: FK CONSTRAINT; Schema: phonebook; Owner: edusysuser
--

ALTER TABLE ONLY follow_up
    ADD CONSTRAINT fk2da6cde9d3e5b02f FOREIGN KEY (owner_id) REFERENCES official.employee(person_id);


--
-- Name: fkd5065e6193e47fa9; Type: FK CONSTRAINT; Schema: phonebook; Owner: edusysuser
--

ALTER TABLE ONLY phone_entry
    ADD CONSTRAINT fkd5065e6193e47fa9 FOREIGN KEY (department_id) REFERENCES education.department(id);


--
-- Name: fkd5065e61a73ff654; Type: FK CONSTRAINT; Schema: phonebook; Owner: edusysuser
--

ALTER TABLE ONLY phone_entry
    ADD CONSTRAINT fkd5065e61a73ff654 FOREIGN KEY (employee_id) REFERENCES official.employee(person_id);


SET search_path = public, pg_catalog;

--
-- Name: fk15d7824c1979e57d; Type: FK CONSTRAINT; Schema: public; Owner: edusysuser
--

ALTER TABLE ONLY followup
    ADD CONSTRAINT fk15d7824c1979e57d FOREIGN KEY (phone_entry_id) REFERENCES phoneentry(id);


--
-- Name: public; Type: ACL; Schema: -; Owner: postgres
--

REVOKE ALL ON SCHEMA public FROM PUBLIC;
REVOKE ALL ON SCHEMA public FROM postgres;
GRANT ALL ON SCHEMA public TO postgres;
GRANT ALL ON SCHEMA public TO PUBLIC;


--
-- PostgreSQL database dump complete
--

